package com.ddtpt.android.fantasycompanionapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by e228596 on 6/25/2015.
 */
public class StandingsRecyclerAdapter extends RecyclerView.Adapter<StandingsRecyclerAdapter.StandingsViewHolder> {
    private ArrayList<TeamData> mOwnerData;

    public StandingsRecyclerAdapter(ArrayList<TeamData> ownerData) {mOwnerData = ownerData; }

    @Override
    public StandingsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.standings_individual, parent, false);
        return new StandingsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(StandingsViewHolder rosterViewHolder, int position) {
        TeamData curTeam = mOwnerData.get(position);
        rosterViewHolder.vTeamName.setText(curTeam.getTeamName());
        rosterViewHolder.vRecord.setText(curTeam.getRecord());
        rosterViewHolder.vTotalPoints.setText(String.valueOf(curTeam.getTotalPoints()));
        rosterViewHolder.vOwnerName.setText(curTeam.getTeamOwner());
    }

    @Override
    public int getItemCount() {
        return mOwnerData.size();
    }

    public static class StandingsViewHolder extends RecyclerView.ViewHolder {
        protected TextView vRecord, vTeamName, vOwnerName, vTotalPoints;
        public StandingsViewHolder(View v) {
            super(v);
            vRecord = (TextView)v.findViewById(R.id.standings_record_txt);
            vTeamName = (TextView)v.findViewById(R.id.teamName);
            vOwnerName = (TextView)v.findViewById(R.id.ownerName);
            vTotalPoints = (TextView)v.findViewById(R.id.standings_total_points_txt);
        }
    }
}
