package com.khanhtq.appcore.util;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.khanhtq.appcore.adapters.FooterListAdapter;
import com.khanhtq.appcore.item.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khanhtq on 4/8/16.
 */
public class FooterManager implements FooterListAdapter.ItemClickCallback {
    private Activity mActivity;
    private RecyclerView mFooterListView;
    private FooterListAdapter mFooterAdapter;
    private GoogleMap mMap;

    public FooterManager(Activity activity, RecyclerView footerListView) {
        mActivity = activity;
        mFooterListView = footerListView;
        setUpListView();
    }

    private void setUpListView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false);
        mFooterAdapter = new FooterListAdapter(mActivity, new ArrayList<Team>(), this);
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(mActivity, DividerItemDecoration.HORIZONTAL_LIST);
        mFooterListView.addItemDecoration(itemDecoration);
        mFooterListView.setLayoutManager(layoutManager);
        mFooterListView.setAdapter(mFooterAdapter);
    }

    public void setMapForCallback(GoogleMap map) {
        mMap = map;
    }

    public void addTeam(List<Team> teams) {
        mFooterAdapter.reload(teams);
    }

    @Override
    public void callback(LatLng position) {
        if (mMap != null) {
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(position, Constants.DEFAULT_ZOOM_LEVEL));
        }
    }
}
