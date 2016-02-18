package com.khanhtq.prosoccerteam.util;

import android.os.*;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.khanhtq.prosoccerteam.items.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khanhtq on 2/18/16.
 */
public class SearchTeamRunnable implements Runnable {
    public static final String TAG = SearchTeamRunnable.class.getSimpleName();

    interface TaskSearchTeamMethods {

        /**
         * Returns current position for searching nearest teams
         */
        LatLng getCurrentPosition();

        /**
         * Sets searching result to show on Map;
         */
        void setTeamList(List<Team> resultTeams);

        /**
         * Defines the action for each state of Search Team Task instance.
         * @param state The current State of the Task.
         */
        void handleSearchState(int state);
    }

    private TaskSearchTeamMethods mSearchTeamTask;

    SearchTeamRunnable(TaskSearchTeamMethods searchTeamTask) {
        mSearchTeamTask = searchTeamTask;
    }

    @Override
    public void run() {
        android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
        mSearchTeamTask.handleSearchState(SearchLocationManager.SEARCH_TEAM_STARTED);
        final LatLng currentPosition = mSearchTeamTask.getCurrentPosition();
        List<Team> results = new ArrayList<Team>();
        if (currentPosition != null) {
            for (Team team : Constants.TEAM_LIST) {
                LatLng teamPos = team.getAddress();
                double distance = team.calculateByDistance(currentPosition);
                if (distance < Constants.TEAM_MAX_DISTANCE) {
                    results.add(team);
                }
            }
            Log.d(TAG, "Search results size: " + results.size());
            mSearchTeamTask.setTeamList(results);
            mSearchTeamTask.handleSearchState(SearchLocationManager.SEARCH_TEAM_COMPLETE);
        }
    }
}
