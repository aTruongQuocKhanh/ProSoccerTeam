package com.khanhtq.prosoccerteam.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.clustering.ClusterManager;
import com.khanhtq.appcore.activities.WebViewActivity;
import com.khanhtq.appcore.item.Country;
import com.khanhtq.appcore.item.Team;
import com.khanhtq.appcore.util.TeamRender;
import com.khanhtq.appcore.util.Constants;
import com.khanhtq.appcore.view.ViewInterface;
import com.khanhtq.prosoccerteam.R;
import com.khanhtq.prosoccerteam.adapter.ArenaTeamInfoWindowAdapter;
import com.khanhtq.prosoccerteam.util.SearchLocationManager;

import java.util.List;

/**
 * Created by khanhtq on 2/16/16.
 */
public class MainActivity extends AppCompatActivity implements OnMapReadyCallback,
        GoogleMap.OnCameraChangeListener,
        LocationListener,
        ClusterManager.OnClusterItemInfoWindowClickListener<Team>,
        ClusterManager.OnClusterItemClickListener<Team>,
        NavigationView.OnNavigationItemSelectedListener,
        ViewInterface.CallBackView<Team> {
    public static final String TAG = MainActivity.class.getSimpleName();
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    private View mSplashView;
    private Toolbar mToolbar;
    private DrawerLayout mDrawerlayout;
    private NavigationView mNavigationView;
    private ActionBarDrawerToggle mDrawerToggle;

    private Handler mHandler;
    private GoogleMap mMap;
    private LocationManager mLocationManager;
    private ClusterManager<Team> mClusterManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerlayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navigationView);

        setupActionBar();

        mHandler = new Handler();

        handleSplash();

        SearchLocationManager.getInstance().setViewCallback(this);

        setupNavigationBar();

        setupMap();
    }

    private void setupActionBar() {
        // show header view
        mToolbar = (Toolbar) findViewById(R.id.toolbar_layout);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void handleSplash() {
        mSplashView = findViewById(R.id.splash_layout);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mSplashView.getVisibility() != View.GONE) {
                    mSplashView.animate().setDuration(500).alpha(0).start();
                    mSplashView.setVisibility(View.GONE);
                }
            }
        }, 500);
    }

    private void setupNavigationBar() {
        mNavigationView.setNavigationItemSelectedListener(this);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerlayout, mToolbar, R.string.app_name, R.string.app_name);
        mDrawerlayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }

    private void setupMap() {
        // load map
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerlayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mClusterManager = new ClusterManager<Team>(this, mMap);
        mClusterManager.setRenderer(new TeamRender(this, mMap, mClusterManager));
        mMap.setInfoWindowAdapter(new ArenaTeamInfoWindowAdapter(this));
        mMap.setOnCameraChangeListener(this);
        mMap.setOnMarkerClickListener(mClusterManager);
        mMap.setOnInfoWindowClickListener(mClusterManager);
        mClusterManager.setOnClusterItemInfoWindowClickListener(this);
        enableMyLocation();
    }

    /**
     * Enable current location
     */
    private void enableMyLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "Not grant permission");
            if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_REQUEST_CODE);
            }
        } else if (mMap != null) {
            Log.d(TAG, "Map != null");
            mMap.setMyLocationEnabled(true);
            mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
            String provider = mLocationManager.getBestProvider(new Criteria(), true);
            Location location = mLocationManager.getLastKnownLocation(provider);
            if (location != null) {
                onLocationChanged(location);
            }
            mLocationManager.requestLocationUpdates(provider, Constants.UPDATE_LOCATION_TIME, 0, this);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (permissions.length == 1 &&
                    permissions[0] == Manifest.permission.ACCESS_FINE_LOCATION &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                enableMyLocation();
            }
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        LatLng newPos = new LatLng(latitude, longitude);
        if (mMap != null) {
            mMap.moveCamera(CameraUpdateFactory.newLatLng(newPos));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(Constants.DEFAULT_ZOOM_LEVEL));
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onCameraChange(CameraPosition cameraPosition) {
        Log.d(TAG, "onCameraChange --- camera position is " + cameraPosition.target.latitude + "/" + cameraPosition.target.longitude);
        if (mMap != null) {
            SearchLocationManager.recalculateDistanceByZoomLevel(cameraPosition.zoom);
            SearchLocationManager.startSearchTeam(mNavigationView.getMenu(), mMap, cameraPosition.target);
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        String countryName = item.getTitle().toString();
        Country country = null;
        for (Country c : Constants.COUNTRIES) {
            if (countryName.equals(c.getName())) {
                country = c;
                break;
            }
        }
        if (country != null && mMap != null) {
            mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(country.getBound(), 50));
        }
        mDrawerlayout.closeDrawers();
        return true;
    }

    @Override
    public void callBack(List<Team> datas) {
        for (Team t : datas) {
            mClusterManager.addItem(t);
        }
        mClusterManager.cluster();
    }

    @Override
    public void onClusterItemInfoWindowClick(Team team) {
        Intent webIntent = new Intent(this, WebViewActivity.class);
        webIntent.putExtra(WebViewActivity.URL_KEY, team.getWebAddress());
        startActivity(webIntent);
    }

    @Override
    public boolean onClusterItemClick(Team team) {
        return false;
    }
}