package com.khanhtq.prosoccerteam.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.khanhtq.prosoccerteam.items.Team;

import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by khanhtq on 2/18/16.
 */
public class SearchLocationManager {
    public static final int SEARCH_TEAM_STARTED = 1;

    public static final int SEARCH_TEAM_COMPLETE = 2;

    private static final int KEEP_ALIVE_TIME = 1;

    private static final TimeUnit KEEP_ALIVE_TIME_UNIT;

    private static final int CORE_POOL_SIZE = 8;

    private static final int MAX_POOL_SIZE = 8;

    private Handler mHandler;

    private BlockingDeque<Runnable> mSearchTeamQueue;

    private ThreadPoolExecutor mSearchTeamThreadPool;

    private static SearchLocationManager mInstance;

    static {
        KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;
    }

    SearchLocationManager() {
        mSearchTeamQueue = new LinkedBlockingDeque<Runnable>();

        mSearchTeamThreadPool = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT, mSearchTeamQueue);

        mHandler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(Message msg) {
                SearchTask searchTask = (SearchTask) msg.obj;
                GoogleMap googleMap = searchTask.getMap();
                List<Team> results = searchTask.getTeamList();
                if (googleMap != null) {
                    switch (msg.what) {
                        case SEARCH_TEAM_COMPLETE:
                            if (results != null && results.size() > 0) {
                                for (Team team : results) {
                                    Marker marker = googleMap.addMarker(new MarkerOptions()
                                            .position(team.getAddress())
                                            .title(team.getName())
                                            .icon(BitmapDescriptorFactory.fromResource(team.getIconDrawable()))
                                            .infoWindowAnchor(0.5f, 0.5f));
                                }
                                searchTask.eraseTeamList();
                            }
                            break;
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

    public static void startSearchTeam(GoogleMap map, LatLng position) {
        SearchTask searchTask = (SearchTask) mInstance.mSearchTeamQueue.poll();

        if (searchTask == null) {
            searchTask = new SearchTask();
        }

        searchTask.initializeSearchTeamTask(mInstance, map);
        searchTask.setCurrentPosition(position);

        if (searchTask.getTeamList() == null) {
            mInstance.mSearchTeamThreadPool.execute(searchTask.getSearchTeamRunnable());
        } else {
            mInstance.handleState(searchTask, SEARCH_TEAM_COMPLETE);
        }
    }

    void handleState(SearchTask searchTask, int state) {
        switch (state) {
            case SEARCH_TEAM_COMPLETE:
                Message successMessage = mHandler.obtainMessage(state, searchTask);
                successMessage.sendToTarget();
            default:
                mHandler.obtainMessage(state, searchTask).sendToTarget();
                break;
        }
    }
}
