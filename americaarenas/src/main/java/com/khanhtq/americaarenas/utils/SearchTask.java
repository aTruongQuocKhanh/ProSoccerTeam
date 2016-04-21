package com.khanhtq.americaarenas.utils;


import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.khanhtq.appcore.item.League;
import com.khanhtq.appcore.item.Team;
import com.khanhtq.appcore.util.SearchTeamRunnable;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by khanhtq on 2/18/16.
 */
class SearchTask implements SearchTeamRunnable.TaskSearchTeamMethods {
    private static SearchLocationManager mSearchLocationManager;

    private WeakReference<GoogleMap> mMap;

    private List<Team> mTeamList = null;

    private League mCurrentLeague;

    private final ArenaSearchTeamRunnable mSearchTeamRunnable;

    private LatLng mCurrentPosition;

    private Thread mCurrentThread;

    SearchTask() {
        mSearchTeamRunnable = new ArenaSearchTeamRunnable(this);
    }

    void initializeSearchTeamTask(SearchLocationManager manager,
                                  GoogleMap map, League currentLeague) {
        mSearchLocationManager = manager;
        mMap = new WeakReference<GoogleMap>(map);
        mCurrentLeague = currentLeague;
    }

    public GoogleMap getMap() {
        return mMap.get();
    }


    public Thread getCurrentThread() {
        synchronized (mSearchLocationManager) {
            return mCurrentThread;
        }
    }

    public void setCurrentThread(Thread thread) {
        synchronized (mSearchLocationManager) {
            mCurrentThread = thread;
        }
    }

    @Override
    public League getCurrentLeague() {
        return mCurrentLeague;
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
    public void handleSearchTeamState(int state) {
        mSearchLocationManager.handleState(this, state);
    }

    public List<Team> getTeamList() {
        return mTeamList;
    }

    public void setCurrentPosition(LatLng currentPosition) {
        mCurrentPosition = currentPosition;
    }

    Runnable getSearchTeamRunnable() {
        return mSearchTeamRunnable;
    }

    /**
     * Recycles an PhotoTask object before it's put back into the pool. One reason to do
     * this is to avoid memory leaks.
     */
    void recycle() {
        // Deletes the weak reference to the google map
        if (null != mMap) {
            mMap.clear();
            mMap = null;
        }
        mTeamList = null;
    }
}
