package com.khanhtq.prosoccerteam.util;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.khanhtq.prosoccerteam.items.Team;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by khanhtq on 2/18/16.
 */
public class SearchTask implements SearchTeamRunnable.TaskSearchTeamMethods {
    private static SearchLocationManager mSearchLocationManager;

    private WeakReference<GoogleMap> mMap;

    private List<Team> mTeamList = null;

    private SearchTeamRunnable mSearchTeamRunnable;

    private LatLng mCurrentPosition;

    SearchTask() {
        mSearchTeamRunnable = new SearchTeamRunnable(this);
    }

    void initializeSearchTeamTask(SearchLocationManager manager,
                                  GoogleMap map) {
        mSearchLocationManager = manager;
        mMap = new WeakReference<GoogleMap>(map);
    }

    public GoogleMap getMap() {
        return mMap.get();
    }

    @Override
    public LatLng getCurrentPosition() {
        return mCurrentPosition;
    }

    @Override
    public void setTeamList(List<Team> resultTeams) {
        mTeamList = resultTeams;
    }

    @Override
    public void handleSearchState(int state) {
        mSearchLocationManager.handleState(this, state);
    }

    public List<Team> getTeamList() {
        return mTeamList;
    }

    public void eraseTeamList() {
        synchronized (mSearchLocationManager) {
            mTeamList = null;
        }
    }

    public void setCurrentPosition(LatLng currentPosition) {
        mCurrentPosition = currentPosition;
    }

    Runnable getSearchTeamRunnable() {
        return mSearchTeamRunnable;
    }
}
