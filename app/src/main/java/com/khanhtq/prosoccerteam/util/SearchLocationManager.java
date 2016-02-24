package com.khanhtq.prosoccerteam.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.khanhtq.appcore.item.Country;
import com.khanhtq.appcore.item.Team;
import com.khanhtq.appcore.util.Constants;
import com.khanhtq.prosoccerteam.R;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by khanhtq on 2/18/16.
 */
public class SearchLocationManager {
    public static final int SEARCH_TEAM_STARTED = 1;

    public static final int SEARCH_TEAM_COMPLETE = 2;

    public static final int SEARCH_COUNTRY_STARTED = 3;

    public static final int SEARCH_COMPLETE = 4;

    private static final int KEEP_ALIVE_TIME = 1;

    private static final TimeUnit KEEP_ALIVE_TIME_UNIT;

    private static final int CORE_POOL_SIZE = 8;

    private static final int MAX_POOL_SIZE = 8;

    private static final int NUMBER_OF_CORE= Runtime.getRuntime().availableProcessors();

    private Handler mHandler;

    private BlockingQueue<Runnable> mSearchTeamQueue;

    private BlockingQueue<Runnable> mSearchCountryQueue;

    private final Queue<SearchTask> mSearchTaskWorkQueue;

    private ThreadPoolExecutor mSearchTeamThreadPool;

    private ThreadPoolExecutor mSearchCountryThreadPool;

    private static SearchLocationManager mInstance;

    public static float mDistanceByZoomLevel = 1;

    static {
        KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;
    }

    SearchLocationManager() {
        mSearchTeamQueue = new LinkedBlockingQueue<Runnable>();

        mSearchCountryQueue = new LinkedBlockingQueue<Runnable>();

        mSearchTaskWorkQueue = new LinkedBlockingQueue<SearchTask>();

        mSearchTeamThreadPool = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT, mSearchTeamQueue);

        mSearchCountryThreadPool = new ThreadPoolExecutor(NUMBER_OF_CORE, NUMBER_OF_CORE, KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT, mSearchCountryQueue);

        mHandler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                SearchTask searchTask = (SearchTask) msg.obj;
                GoogleMap googleMap = searchTask.getMap();
                Menu menu = searchTask.getMenu();
                List<Team> teams = searchTask.getTeamList();
                List<Country> countries = searchTask.getCountryList();
                if (googleMap != null && menu != null) {
                    switch (msg.what) {
                        case SEARCH_COMPLETE:
                            if (teams != null && teams.size() > 0) {
                                for (Team team : teams) {
                                    googleMap.addMarker(new MarkerOptions()
                                            .position(team.getAddress())
                                            .title(team.getName())
                                            .snippet(team.getWebAddress())
                                            .icon(BitmapDescriptorFactory.fromResource(team.getIconDrawable()))
                                            .infoWindowAnchor(0.5f, 0.5f));
                                }
                            }
                            if (countries != null && countries.size() > 0) {
                                menu.clear();
                                for (Country country : countries) {
                                    MenuItem item = menu.add(country.getName());
                                    item.setIcon(R.drawable.menu_icon);
                                }
                            }
                            recycleTask(searchTask);
                            break;
                        default:
                            super.handleMessage(msg);
                    }
                }
            }
        };
    }

    public static SearchLocationManager getInstance() {
        if (mInstance == null) {
            mInstance = new SearchLocationManager();
        }
        return mInstance;
    }

    public static void recalculateDistanceByZoomLevel(float newZoomLevel) {
        float equatorInDp = 256 * ((float) Math.pow(2, newZoomLevel));
        mDistanceByZoomLevel = ((Constants.DEFAULT_DISTANCE_IN_DP * Constants.EQUATOR_LENGTH) / equatorInDp);
    }

    public static void startSearchTeam(Menu menu, GoogleMap map, LatLng position) {
        SearchTask searchTask = mInstance.mSearchTaskWorkQueue.poll();

        if (searchTask == null) {
            searchTask = new SearchTask();
        }

        searchTask.initializeSearchTeamTask(mInstance, map, menu);
        searchTask.setCurrentPosition(position);

        if (searchTask.getTeamList() == null) {
            mInstance.mSearchTeamThreadPool.execute(searchTask.getSearchTeamRunnable());
        } else {
            mInstance.handleState(searchTask, SEARCH_TEAM_COMPLETE);
        }
    }

    void handleState(SearchTask searchTask, int state) {
        switch (state) {
            case SEARCH_COMPLETE:
                Message successMessage = mHandler.obtainMessage(state, searchTask);
                successMessage.sendToTarget();
                break;
            case SEARCH_TEAM_COMPLETE:
                mSearchCountryThreadPool.execute(searchTask.getSearchCountryRunnable());
            default:
                break;
        }
    }

    /**
     * Recycles tasks by calling their internal recycle() method and then putting them back into
     * the task queue.
     * @param searchTask The task to recycle
     */
    void recycleTask(SearchTask searchTask) {

        // Frees up memory in the task
        searchTask.recycle();

        // Puts the task object back into the queue for re-use.
        mSearchTaskWorkQueue.offer(searchTask);
    }
}
