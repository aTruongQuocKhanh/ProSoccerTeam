package com.khanhtq.americaarenas.adapters;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.model.Marker;
import com.khanhtq.appcore.R;
import com.khanhtq.appcore.adapters.TeamInfoWindowAdapter;
import com.khanhtq.appcore.item.Team;
import com.khanhtq.appcore.util.Constants;
import com.khanhtq.appcore.view.CustomTextView;

/**
 * Created by khanhtq on 2/18/16.
 */
public class AmericaTeamInfoWindowAdapter extends TeamInfoWindowAdapter {

    public AmericaTeamInfoWindowAdapter(Activity activity) {
        super(activity);
    }

    @Override
    protected void render(View view, Marker marker) {
        if (view != null && mTeams != null && mTeams.size() > 0) {
            TextView mNameTextView = (TextView) view.findViewById(R.id.team_name_txt_view);
            TextView mDescTextView = (TextView) view.findViewById(R.id.team_desc_txt_view);
            CustomTextView mDistanceTextView = (CustomTextView) view.findViewById(R.id.distance_txt_view);
            ImageView mTeamIconView = (ImageView) view.findViewById(R.id.team_icon_img_view);
            for (Team team : mTeams) {
                if (team.isPosition(marker.getPosition())) {
                    mNameTextView.setText(team.getName());
                    mDescTextView.setText(team.getDescription());
                    mTeamIconView.setImageResource(team.getIconDrawable());
                    if (mCurrentLocation != null) {
                        float distanceInMile = (float) (team.calculateByDistance(mCurrentLocation) * Constants.KM_TO_MILE);
                        Resources res = mActivity.getResources();
                        String distance = res.getQuantityString(R.plurals.distance, (int) distanceInMile, distanceInMile);
                        mDistanceTextView.setText(distance);
                    }
                }
            }
        }
    }
}
