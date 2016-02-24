package com.khanhtq.appcore.adapters;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.khanhtq.appcore.R;
import com.khanhtq.appcore.item.Team;
import com.khanhtq.appcore.util.Constants;

/**
 * Created by khanhtq on 2/18/16.
 */
public abstract class TeamInfoWindowAdapter implements GoogleMap.InfoWindowAdapter{
    private static final String TAG = TeamInfoWindowAdapter.class.getSimpleName();

    private Activity mActivity;
    private final View mWindows;

    public TeamInfoWindowAdapter(Activity activity) {
        mActivity = activity;
        mWindows = activity.getLayoutInflater().inflate(R.layout.team_info_window, null);
    }

    @Override
    public View getInfoWindow(Marker marker) {
        render(mWindows, marker);
        return mWindows;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }

    protected abstract void render(View view, Marker marker);
}
