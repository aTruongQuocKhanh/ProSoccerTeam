package com.khanhtq.appcore.adapters;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;
import com.khanhtq.appcore.R;
import com.khanhtq.appcore.item.Team;
import com.khanhtq.appcore.util.Constants;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by khanhtq on 4/12/16.
 */
public class TeamListAdapter extends RecyclerView.Adapter<TeamListAdapter.TeamHolder> {
    private static final int SEARCH_ADDRESS_SUCCESS = 200;
    private Context mContext;
    private List<Team> mTeamList;
    private LatLng mCurrentLocation;

    public TeamListAdapter(Context context, List<Team> teamList) {
        mContext = context;
        mTeamList = teamList;
    }


    public void updateNewLocation(LatLng newLocation) {
        mCurrentLocation = newLocation;
        notifyDataSetChanged();
    }

    @Override
    public TeamHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.team_list_item, parent, false);
        return new TeamHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TeamHolder holder, int position) {
        final TeamHolder teamHolder = holder;
        final Team team = getItem(position);

        if (team != null) {
            teamHolder.mTeamIcon.setImageResource(team.getIconDrawable());
            teamHolder.mTeamName.setText(team.getName());
            GetAddressTask getAddressTask = new GetAddressTask(teamHolder.mTeamAddress);
            getAddressTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, team.getPosition());
            if (mCurrentLocation != null) {
                teamHolder.mDistance.setText(Math.round(team.calculateByDistance(mCurrentLocation)) + Constants.MILE_SIGN);
            }
        }
    }

    private Team getItem(int position) {
        return (mTeamList == null || mTeamList.size() <= position) ? null : mTeamList.get(position);
    }

    @Override
    public int getItemCount() {
        return (mTeamList == null) ? 0 : mTeamList.size();
    }

    class TeamHolder extends RecyclerView.ViewHolder {
        ImageView mTeamIcon;
        TextView mTeamName;
        TextView mTeamAddress;
        TextView mDistance;

        public TeamHolder(View itemView) {
            super(itemView);
            mTeamIcon = (ImageView) itemView.findViewById(R.id.team_img_view);
            mTeamName = (TextView) itemView.findViewById(R.id.team_name_txt_view);
            mTeamAddress = (TextView) itemView.findViewById(R.id.team_address_txt_view);
            mDistance = (TextView) itemView.findViewById(R.id.distance_txt_view);
        }
    }

    private class GetAddressTask extends AsyncTask<LatLng, Void, String> {

        private TextView mAddressView;

        GetAddressTask(TextView addressView) {
            mAddressView = addressView;
        }

        @Override
        protected String doInBackground(LatLng... params) {
            String locationName = "";
            LatLng location = params[0];
            Geocoder geocoder = new Geocoder(mContext, Locale.getDefault());
            try {
                List<Address> listAddresses = geocoder.getFromLocation(location.latitude, location.longitude, 1);
                if (null != listAddresses && listAddresses.size() > 0) {
                    locationName = listAddresses.get(0).getAddressLine(0);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return locationName;
        }

        @Override
        protected void onPostExecute(String location) {
            mAddressView.setText(location);
        }
    }
}
