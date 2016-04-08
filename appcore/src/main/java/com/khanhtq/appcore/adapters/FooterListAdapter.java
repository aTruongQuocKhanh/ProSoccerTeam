package com.khanhtq.appcore.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

    public FooterListAdapter(Activity activity,List<Team> teams) {
        mTeams = teams;
    }

    public void reload(List<Team> newTeams) {
        mTeams = new ArrayList<>();
        mTeams.addAll(newTeams);
        notifyDataSetChanged();
    }

    @Override
    public FooterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mContext.getLayoutInflater().inflate(R.layout.footer_team_item_view, parent, false);
        FooterHolder holder = new FooterHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(FooterHolder holder, int position) {
        Team team = getItem(position);
        if (team != null) {
            holder.mTeamIcon.setImageResource(team.getIconDrawable());
            holder.mTeamName.setText(team.getName());
        }
    }

    private Team getItem(int position) {
        return (mTeams == null || mTeams.size() - 1 < position) ? null : mTeams.get(position);
    }

    @Override
    public int getItemCount() {
        return (mTeams == null) ? 0 : mTeams.size();
    }

    class FooterHolder extends RecyclerView.ViewHolder {
        ImageView mTeamIcon;
        TextView mTeamName;

        FooterHolder(View itemView) {
            super(itemView);
        }
    }
}
