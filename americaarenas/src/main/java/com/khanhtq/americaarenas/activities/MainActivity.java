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
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterManager;
import com.khanhtq.americaarenas.R;
import com.khanhtq.americaarenas.adapters.AmericaTeamInfoWindowAdapter;
import com.khanhtq.americaarenas.utils.Constant;
import com.khanhtq.americaarenas.utils.SearchLocationManager;
import com.khanhtq.appcore.activities.TeamListActivity;
import com.khanhtq.appcore.activities.WebViewActivity;
import com.khanhtq.appcore.item.League;
import com.khanhtq.appcore.item.Team;
import com.khanhtq.appcore.util.Constants;
import com.khanhtq.appcore.util.FooterManager;
import com.khanhtq.appcore.util.PreferenceUtil;
import com.khanhtq.appcore.util.TeamRender;
import com.khanhtq.appcore.view.ViewInterface;

import io.fabric.sdk.android.Fabric;
import java.util.List;

/**
 * Created by khanhtq on 2/23/16.
 */
public class MainActivity extends AppCompatActivity implements OnMapReadyCallback,
        GoogleMap.OnCameraChangeListener,
        LocationListener,
        ClusterManager.OnClusterItemInfoWindowClickListener<Team>,
        ClusterManager.OnClusterItemClickListener<Team>,
        ClusterManager.OnClusterClickListener<Team>,
        NavigationView.OnNavigationItemSelectedListener,
        ViewInterface.CallBackView<Team>  {
    public static final String TAG = MainActivity.class.getSimpleName();
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private static final LatLngBounds UNITED_STATES = new LatLngBounds(new LatLng(18.9106768, 172.4458955), new LatLng(71.3867745, -66.9502861));
    private static final String ORDER_KEY = "ORDER";

    private View mSplashView;
    private Toolbar mToolbar;
    private DrawerLayout mDrawerlayout;
    private NavigationView mNavigationView;
    private ActionBarDrawerToggle mDrawerToggle;

    private Handler mHandler;
    private GoogleMap mMap;
    private LocationManager mLocationManager;
    private League mCurrentLeague;
    private boolean hasChangeLeague = false;
    private ClusterManager<Team> mClusterManager;
    private FooterManager mFooterManager;
    private AmericaTeamInfoWindowAdapter mInfoWindowAdapter;
    private PreferenceUtil mPreferenceUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

        mCurrentLeague = Constants.ALL_LEAGUE;
        mInfoWindowAdapter = new AmericaTeamInfoWindowAdapter(this);
        mPreferenceUtil = PreferenceUtil.getInstance(this).initialize();
        mHandler = new Handler();

        hideSplash();
        setupActionBar();

        SearchLocationManager.getInstance().setViewCallback(this);

        setupNavigationView();
        initializeMenu();
        setupFooter();
        setupMap();
    }

    /**
     * Set up support toolbar.
     */
    private void setupActionBar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar_layout);
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.header_hamburger);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * Hide splash screen after 2000ms.
     */
    private void hideSplash() {
        mSplashView = findViewById(R.id.splash_layout);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mSplashView.getVisibility() != View.GONE) {
                    mSplashView.setVisibility(View.GONE);
                }
            }
        }, 2000);
    }

    /**
     * Initialize navigation menu
     */
    private void initializeMenu() {
        Menu menu = mNavigationView.getMenu();
        for (int i = 0; i < Constants.AMERICA_LEAGUE.length; i++) {
            Intent action = new Intent();
            action.putExtra(ORDER_KEY, i);
            MenuItem item = menu.add(Constants.AMERICA_LEAGUE[i].getName() + Constants.WHITE_SPACE + "(" + Constants.AMERICA_LEAGUE[i].getType() + ")");
            item.setIcon(getResources().getDrawable(Constant.MENU_ICONS[i]));
            item.setIntent(action);
        }
    }

    /**
     * Set up left navigation.
     */
    private void setupNavigationView() {
        mDrawerlayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navigationView);
        mNavigationView.setNavigationItemSelectedListener(this);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerlayout, mToolbar, R.string.app_name, R.string.app_name);
        mDrawerlayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }

    /**
     * Load map async
     */
    private void setupMap() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void setupFooter() {
        RecyclerView mFooterListView = (RecyclerView) findViewById(R.id.footer_team_recyclerview);
        mFooterManager = new FooterManager(this, mFooterListView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerlayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.open_team:
                Intent teamIntent = new Intent(this, TeamListActivity.class);
                startActivity(teamIntent);
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
        mMap.setInfoWindowAdapter(mInfoWindowAdapter);
        mMap.setOnCameraChangeListener(this);
        mMap.setOnMarkerClickListener(mClusterManager);
        mMap.setOnInfoWindowClickListener(mClusterManager);
        mClusterManager.setOnClusterItemInfoWindowClickListener(this);
        mClusterManager.setOnClusterClickListener(this);
        mFooterManager.setMapForCallback(mMap);
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
        mInfoWindowAdapter.setNewLocation(newPos);
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
        // TO-DO: do nothing here
    }

    @Override
    public void onProviderDisabled(String provider) {
        // TO-DO: do nothing here
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
    public boolean onNavigationItemSelected(MenuItem item) {
        Intent intent = item.getIntent();
        if (intent == null || !intent.hasExtra(ORDER_KEY)) {
            mDrawerlayout.closeDrawers();
            return true;
        }
        int itemOrder = intent.getIntExtra(ORDER_KEY, 0);
        Log.d(TAG, "onNavigationItemSelected(MenuItem item) --- item order is " + itemOrder);
        mCurrentLeague = Constants.AMERICA_LEAGUE[itemOrder];
        hasChangeLeague = true;
        if (mMap != null) {
            mMap.clear();
            mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(UNITED_STATES, 50));
        }
        mDrawerlayout.closeDrawers();
        return true;
    }

    @Override
    public boolean onClusterItemClick(Team team) {
        return false;
    }

    @Override
    public void onClusterItemInfoWindowClick(Team team) {
        Intent webIntent = new Intent(this, WebViewActivity.class);
        webIntent.putExtra(WebViewActivity.URL_KEY, team.getWebAddress());
        startActivity(webIntent);
    }

    @Override
    public void callBack(List<Team> teams) {
        for (Team t : teams) {
            mClusterManager.addItem(t);
        }
        mClusterManager.cluster();
        if (hasChangeLeague) {
            mFooterManager.addTeam(teams);
            mPreferenceUtil.setListObject(TeamListActivity.TEAM_LIST_KEY, teams);
            hasChangeLeague = false;
        }
    }

    @Override
    public boolean onClusterClick(Cluster<Team> cluster) {
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cluster.getPosition(), mMap.getCameraPosition().zoom + 2));
        return true;
    }
}
