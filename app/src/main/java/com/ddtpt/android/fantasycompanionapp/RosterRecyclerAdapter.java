package com.ddtpt.android.fantasycompanionapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e228596 on 6/17/2015.
 */
public class RosterRecyclerAdapter extends RecyclerView.Adapter<RosterRecyclerAdapter.RosterViewHolder> {
    private List<JsonFactory.Player> playerList;

    public RosterRecyclerAdapter(List<JsonFactory.Player> players) {
        playerList = players;
    }

    @Override
    public RosterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.relative_player_cardview, parent, false);
        return new RosterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RosterViewHolder holder, int position) {
        JsonFactory.Player curPlayer = playerList.get(position);
        holder.vPlayerName.setText(curPlayer.getName().getFull());
        holder.vPlayerNumber.setText(String.valueOf(curPlayer.getUniform_number()));
        //holder.vPlayerGameData.setText(curPlayer.getPlayerGameDetails());
        //holder.vPlayerFantasyPoints.setText(Double.toString(curPlayer.getPlayerFantasyPoints()));
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

    public static class RosterViewHolder extends RecyclerView.ViewHolder {
        protected TextView vPlayerName;
        protected TextView vPlayerNumber;
        protected Button vPlayerPosition;
        protected TextView vPlayerGameData;
        protected TextView vPlayerFantasyPoints;

        public RosterViewHolder(View v) {
            super(v);
            vPlayerName = (TextView)v.findViewById(R.id.name);
            vPlayerNumber = (TextView)v.findViewById(R.id.number);
            vPlayerPosition = (Button)v.findViewById(R.id.position);
            vPlayerGameData = (TextView)v.findViewById(R.id.gameDetails);
            vPlayerFantasyPoints = (TextView)v.findViewById(R.id.fantasyScore);
        }
    }

}

