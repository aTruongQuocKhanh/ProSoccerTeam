package com.khanhtq.prosoccerteam.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.khanhtq.prosoccerteam.R;
import com.khanhtq.prosoccerteam.items.Team;
import com.khanhtq.prosoccerteam.util.Constants;

/**
 * Created by khanhtq on 2/18/16.
 */
public class TeamInfoWindowAdapter implements GoogleMap.InfoWindowAdapter, View.OnClickListener {
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

    private void render(View view, Marker marker) {
        if (view != null) {
            TextView mNameTextView = (TextView) view.findViewById(R.id.team_name_txt_view);
            TextView mDescTextView = (TextView) view.findViewById(R.id.team_desc_txt_view);
            TextView mLinkTextView = (TextView) view.findViewById(R.id.team_link_txt_view);
            TextView mWikiTextView = (TextView) view.findViewById(R.id.team_wiki_txt_view);
            mLinkTextView.setOnClickListener(this);
            mWikiTextView.setOnClickListener(this);
            for (Team team : Constants.TEAM_LIST) {
                if (team.isPosition(marker.getPosition())) {
                    mNameTextView.setText(team.getName());
                    mDescTextView.setText(team.getDescription());
                    mLinkTextView.setText(team.getWebAddress());
                    mWikiTextView.setText(team.getWikiAddress());
                }
            }
        }
    }

    @Override
    public void onClick(View v) {

    }
}
