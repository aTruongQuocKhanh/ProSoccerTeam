package com.khanhtq.appcore.activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;
import com.khanhtq.appcore.R;
import com.khanhtq.appcore.adapters.TeamListAdapter;
import com.khanhtq.appcore.item.Team;
import com.khanhtq.appcore.util.Constants;
import com.khanhtq.appcore.util.PreferenceUtil;
import com.khanhtq.appcore.util.RecyclerViewDivider;

import java.util.List;

/**
 * Created by khanhtq on 4/11/16.
 */
public class TeamListActivity extends AppCompatActivity implements
        LocationListener {
    public static final String TAG = TeamListActivity.class.getSimpleName();
    public static final String TEAM_LIST_KEY = "TEAM_LIST_KEY";
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    private TextView mTitleView;
    private RecyclerView mTeamListView;

    private TeamListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Team> mListTeam;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_list);
        setUpToolbar();

        loadTeamList();
    }

    private void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_layout);
        mTitleView = (TextView) toolbar.findViewById(R.id.title_txt_view);
        toolbar.setTitle("");
        mTitleView.setText(getResources().getString(R.string.team));
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.teamdetailback);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void loadTeamList() {
        mTeamListView = (RecyclerView) findViewById(R.id.teams_recyclerview);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mTeamListView.setLayoutManager(mLayoutManager);
        mTeamListView.addItemDecoration(new RecyclerViewDivider(1));
        mListTeam = PreferenceUtil.getInstance(this).getListObject(TEAM_LIST_KEY);
        if (mListTeam != null) {
            mAdapter = new TeamListAdapter(this, mListTeam);
            mTeamListView.setAdapter(mAdapter);
            LocationManager mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
            String provider = mLocationManager.getBestProvider(new Criteria(), true);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            Location location = mLocationManager.getLastKnownLocation(provider);
            if (location != null) {
                onLocationChanged(location);
            }
            mLocationManager.requestLocationUpdates(provider, Constants.UPDATE_LOCATION_TIME, 0, this);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        if (mAdapter != null) {
            mAdapter.updateNewLocation(new LatLng(location.getLatitude(), location.getLongitude()));
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
}
