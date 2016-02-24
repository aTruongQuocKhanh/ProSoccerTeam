package com.khanhtq.americaarenas.adapters;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.khanhtq.appcore.R;
import com.khanhtq.appcore.adapters.TeamInfoWindowAdapter;
import com.khanhtq.appcore.item.Team;
import com.khanhtq.appcore.util.Constants;

/**
 * Created by khanhtq on 2/18/16.
 */
public class AmericaTeamInfoWindowAdapter extends TeamInfoWindowAdapter {
    public AmericaTeamInfoWindowAdapter(Activity activity) {
        super(activity);
    }

    @Override
    protected void render(View view, Marker marker) {
        if (view != null) {
            TextView mNameTextView = (TextView) view.findViewById(R.id.team_name_txt_view);
            TextView mDescTextView = (TextView) view.findViewById(R.id.team_desc_txt_view);
            TextView mLinkTextView = (TextView) view.findViewById(R.id.team_link_txt_view);
            TextView mWikiTextView = (TextView) view.findViewById(R.id.team_wiki_txt_view);
            for (Team team : Constants.AMERICA_TEAM_LIST) {
                if (team.isPosition(marker.getPosition())) {
                    mNameTextView.setText(team.getName());
                    mDescTextView.setText(team.getDescription());
                    mLinkTextView.setText(team.getWebAddress());
                    mWikiTextView.setText(team.getWikiAddress());
                }
            }
        }
    }
}
