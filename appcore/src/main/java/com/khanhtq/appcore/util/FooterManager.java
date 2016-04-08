package com.khanhtq.appcore.util;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.khanhtq.appcore.adapters.FooterListAdapter;
import com.khanhtq.appcore.item.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khanhtq on 4/8/16.
 */
public class FooterManager {
    private Activity mActivity;
    private RecyclerView mFooterListView;
    private FooterListAdapter mFooterAdapter;

    public FooterManager(Activity activity, RecyclerView footerListView) {
        mActivity = activity;
        mFooterListView = footerListView;
        setUpListView();
    }

    private void setUpListView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false);
        mFooterAdapter = new FooterListAdapter(mActivity, new ArrayList<Team>());
        mFooterListView.setLayoutManager(layoutManager);
        mFooterListView.setAdapter(mFooterAdapter);
    }

    public void addTeam(List<Team> teams) {
        mFooterAdapter.reload(teams);
    }
}
