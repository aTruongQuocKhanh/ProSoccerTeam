package com.khanhtq.appcore.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.quadtree.PointQuadTree;
import com.khanhtq.appcore.R;
import com.khanhtq.appcore.item.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khanhtq on 4/8/16.
 */
public class FooterListAdapter extends RecyclerView.Adapter<FooterListAdapter.FooterHolder> {
    private Activity mContext;
    private List<Team> mTeams;
    private ItemClickCallback mItemClickCallBack;

    public FooterListAdapter(Activity activity, List<Team> teams, ItemClickCallback itemClickCallBack) {
        mContext = activity;
        mTeams = teams;
        mItemClickCallBack = itemClickCallBack;
    }

    public void reload(List<Team> newTeams) {
        if (mTeams.contains(newTeams.get(0))) {
            return;
        }
        mTeams = new ArrayList<>();
        mTeams.addAll(newTeams);
        notifyDataSetChanged();
    }

    @Override
    public FooterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.footer_team_item_view, parent, false);
        FooterHolder holder = new FooterHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(FooterHolder holder, int position) {
        Team team = getItem(position);
        if (team != null) {
            holder.mTeamIcon.setImageResource(team.getIconDrawable());
            holder.mTeamName.setText(team.getName());
            holder.position = position;
        }
    }

    private Team getItem(int position) {
        return (mTeams == null || mTeams.size() <= position) ? null : mTeams.get(position);
    }

    @Override
    public int getItemCount() {
        return (mTeams == null) ? 0 : mTeams.size();
    }

    class FooterHolder extends RecyclerView.ViewHolder {
        ImageView mTeamIcon;
        TextView mTeamName;
        int position;

        FooterHolder(final View itemView) {
            super(itemView);
            mTeamIcon = (ImageView) itemView.findViewById(R.id.team_icon);
            mTeamName = (TextView) itemView.findViewById(R.id.team_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Team currentTeam = getItem(position);
                    if (currentTeam != null) {
                        mItemClickCallBack.callback(currentTeam.getPosition());
                    }
                }
            });
        }
    }

    public interface ItemClickCallback {
        void callback(LatLng position);
    }
}
