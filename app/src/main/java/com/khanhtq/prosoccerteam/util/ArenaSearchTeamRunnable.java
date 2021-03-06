package com.khanhtq.prosoccerteam.util;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.khanhtq.appcore.item.Team;
import com.khanhtq.appcore.util.Constants;
import com.khanhtq.appcore.util.SearchTeamRunnable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khanhtq on 2/18/16.
 */
public class ArenaSearchTeamRunnable extends SearchTeamRunnable{
    public static final String TAG = ArenaSearchTeamRunnable.class.getSimpleName();

    public ArenaSearchTeamRunnable(TaskSearchTeamMethods searchTeamTask) {
        super(searchTeamTask);
    }

    @Override
    public void doSearch() {
        final TaskSearchTeamMethods mSearchTeamTask = getSearchTeamTask();
        android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
        mSearchTeamTask.handleSearchTeamState(SearchLocationManager.SEARCH_TEAM_STARTED);
        final LatLng currentPosition = mSearchTeamTask.getCurrentPosition();
        List<Team> results = new ArrayList<Team>();
        if (currentPosition != null) {
            for (Team team : Constants.ARENA_TEAM_LIST) {
                double distance = team.calculateByDistance(currentPosition);
                if (distance < SearchLocationManager.mDistanceByZoomLevel) {
                    results.add(team);
                }
            }
            Log.d(TAG, "Search results size: " + results.size());
            mSearchTeamTask.setTeamList(results);
            mSearchTeamTask.handleSearchTeamState(SearchLocationManager.SEARCH_TEAM_COMPLETE);
        }
    }

}
