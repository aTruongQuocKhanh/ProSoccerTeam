package com.khanhtq.appcore.util;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.khanhtq.appcore.item.League;
import com.khanhtq.appcore.item.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khanhtq on 2/18/16.
 */
public abstract class SearchTeamRunnable implements Runnable {
    public static final String TAG = SearchTeamRunnable.class.getSimpleName();

    public interface TaskSearchTeamMethods {
        /**
         * Returns current League select on Menu for America Arena application
         * @return the current league.
         */
        League getCurrentLeague();

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
        void handleSearchTeamState(int state);
    }

    private TaskSearchTeamMethods mSearchTeamTask;

    public TaskSearchTeamMethods getSearchTeamTask() {
        return mSearchTeamTask;
    }

    public SearchTeamRunnable(TaskSearchTeamMethods searchTeamTask) {
        mSearchTeamTask = searchTeamTask;
    }

    @Override
    public void run() {
        doSearch();
    }

    public abstract void doSearch();
}
