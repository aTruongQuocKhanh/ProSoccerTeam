package com.khanhtq.americaarenas.activities;

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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.khanhtq.americaarenas.R;
import com.khanhtq.americaarenas.adapters.AmericaTeamInfoWindowAdapter;
import com.khanhtq.americaarenas.utils.SearchLocationManager;
import com.khanhtq.appcore.activities.WebViewActivity;
import com.khanhtq.appcore.adapters.TeamInfoWindowAdapter;
import com.khanhtq.appcore.item.Country;
import com.khanhtq.appcore.item.League;
import com.khanhtq.appcore.util.Constants;

/**
 * Created by khanhtq on 2/23/16.
 */
public class MainActivity extends AppCompatActivity  implements OnMapReadyCallback,
        GoogleMap.OnCameraChangeListener,
        GoogleMap.OnMarkerClickListener,
        GoogleMap.OnInfoWindowClickListener,
        LocationListener,
        NavigationView.OnNavigationItemSelectedListener {
    public static final String TAG = MainActivity.class.getSimpleName();
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private static final LatLngBounds UNITED_STATES = new LatLngBounds(new LatLng(18.9106768, 172.4458955), new LatLng(71.3867745, -66.9502861));
    private static final String ORDER_KEY = "ORDER";

    private View mSplashView;
    private AdView mAdView;
    private Toolbar mToolbar;
    private DrawerLayout mDrawerlayout;
    private NavigationView mNavigationView;
    private ActionBarDrawerToggle mDrawerToggle;

    private Handler mHandler;
    private GoogleMap mMap;
    private LocationManager mLocationManager;
    private AdRequest mAdRequest;
    private League mCurrentLeague;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerlayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navigationView);
        // show header view
        mToolbar = (Toolbar) findViewById(R.id.toolbar_layout);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mSplashView = findViewById(R.id.splash_layout);
        mHandler = new Handler();
        hideSplash();

        mCurrentLeague = Constants.ALL_LEAGUE;
        SearchLocationManager.getInstance();
        initializeMenu();
        mNavigationView.setNavigationItemSelectedListener(this);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerlayout, mToolbar, R.string.app_name, R.string.app_name);
        mDrawerlayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        // load map
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mAdView = (AdView) findViewById(R.id.adView);
        mAdRequest = new AdRequest.Builder().build();
    }

    private void hideSplash() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mSplashView.getVisibility() != View.GONE) {
                    mSplashView.animate().setDuration(500).alpha(0).start();
                    mSplashView.setVisibility(View.GONE);
                    mAdView.loadAd(mAdRequest);
                }
            }
        }, 500);
    }

    private void initializeMenu() {
        Menu menu = mNavigationView.getMenu();
        for (int i = 0; i < Constants.AMERICA_LEAGUE.length; i++) {
            Intent action = new Intent();
            action.putExtra(ORDER_KEY, i);
            MenuItem item = menu.add(Constants.AMERICA_LEAGUE[i].getName() + Constants.WHITE_SPACE + "(" + Constants.AMERICA_LEAGUE[i].getType() + ")");
            item.setIcon(getResources().getDrawable(R.drawable.menu_icon));
            item.setIntent(action);
        }
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
        mMap.setInfoWindowAdapter(new AmericaTeamInfoWindowAdapter(this));
        mMap.setOnCameraChangeListener(this);
        mMap.setOnMarkerClickListener(this);
        mMap.setOnInfoWindowClickListener(this);
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
            SearchLocationManager.startSearchTeam(mMap, cameraPosition.target, mCurrentLeague);
        }
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Log.d(TAG, "onInfoWindowClick at marker " + marker.getTitle());
        Intent webIntent = new Intent(this, WebViewActivity.class);
        webIntent.putExtra(WebViewActivity.URL_KEY, marker.getSnippet());
        startActivity(webIntent);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Intent intent = item.getIntent();
        if (intent == null || !intent.hasExtra(ORDER_KEY)) {
            mDrawerlayout.closeDrawers();
            return true;
        }
        int itemOrder = intent.getIntExtra(ORDER_KEY, 0);
        Log.d(TAG, "onNavigationItemSelected(MenuItem item) --- item order is " + itemOrder);
        mCurrentLeague = Constants.AMERICA_LEAGUE[itemOrder];
        if (mMap != null) {
            mMap.clear();
            mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(UNITED_STATES, 50));
        }
        mDrawerlayout.closeDrawers();
        return true;
    }
}
