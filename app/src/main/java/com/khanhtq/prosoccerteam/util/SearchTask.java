package com.khanhtq.prosoccerteam.util;

import android.view.Menu;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.khanhtq.appcore.item.Country;
import com.khanhtq.appcore.item.League;
import com.khanhtq.appcore.item.Team;
import com.khanhtq.appcore.util.SearchCountryRunnable;
import com.khanhtq.appcore.util.SearchTeamRunnable;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by khanhtq on 2/18/16.
 */
public class SearchTask implements SearchTeamRunnable.TaskSearchTeamMethods,
        SearchCountryRunnable.SearchCountryMethods {
    private static SearchLocationManager mSearchLocationManager;

    private WeakReference<GoogleMap> mMap;

    private WeakReference<Menu> mMenu;

    private List<Team> mTeamList = null;

    private List<Country> mCountryList = null;

    private ArenaSearchTeamRunnable mSearchTeamRunnable;

    private ArenaSearchCountryRunnable mSearchCountryRunnable;

    private LatLng mCurrentPosition;

    private Thread mCurrentThread;

    SearchTask() {
        mSearchTeamRunnable = new ArenaSearchTeamRunnable(this);
        mSearchCountryRunnable = new ArenaSearchCountryRunnable(this);
    }

    void initializeSearchTeamTask(SearchLocationManager manager,
                                  GoogleMap map, Menu menu) {
        mSearchLocationManager = manager;
        mMap = new WeakReference<GoogleMap>(map);
        mMenu = new WeakReference<Menu>(menu);
    }

    public GoogleMap getMap() {
        return mMap.get();
    }

    public Menu getMenu() {
        return mMenu.get();
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
        return null;
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

    Runnable getSearchCountryRunnable() {
        return mSearchCountryRunnable;
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

    @Override
    public void setSearchCountryThread(Thread thread) {
        setCurrentThread(thread);
    }

    @Override
    public void setCountries(List<Country> coutries) {
        mCountryList = coutries;
    }

    @Override
    public LatLng getCurrentCountryLocation() {
        return mCurrentPosition;
    }

    @Override
    public void handleSearchCountryState(int state) {
        mSearchLocationManager.handleState(this, state);
    }

    public List<Country> getCountryList() {
        return mCountryList;
    }
}
