package com.khanhtq.appcore.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.khanhtq.appcore.R;

/**
 * Created by khanhtq on 4/11/16.
 */
public class TeamListActivity extends AppCompatActivity {

    private TextView mTitleView;
    private RecyclerView mTeamListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_list);
        setUpToolbar();
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
}
