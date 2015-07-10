package com.ddtpt.android.fantasycompanionapp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by e228596 on 6/17/2015.
 */
public class RosterRecyclerAdapter extends RecyclerView.Adapter<RosterRecyclerAdapter.RosterViewHolder> {
    private ArrayList<JsonFactory.Player> playerList;
    private SparseBooleanArray selectedItems = new SparseBooleanArray();

    public RosterRecyclerAdapter(ArrayList<JsonFactory.Player> players) {
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
        holder.vPlayerPosition.setText(String.valueOf(curPlayer.getSelected_position().getPosition()));
        holder.vPlayerCard.setSelected(selectedItems.get(position, false));
        //holder.vPlayerGameData.setText(curPlayer.getPlayerGameDetails());
        //holder.vPlayerFantasyPoints.setText(Double.toString(curPlayer.getPlayerFantasyPoints()));
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

    public class RosterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected TextView vPlayerName;
        protected TextView vPlayerNumber;
        protected Button vPlayerPosition;
        protected TextView vPlayerGameData;
        protected TextView vPlayerFantasyPoints;
        protected CardView vPlayerCard;

        final Animation animShrinkToMiddle;
        final Animation animGrowFromMiddle;

        public RosterViewHolder(View v) {
            super(v);
            vPlayerName = (TextView)v.findViewById(R.id.name);
            vPlayerNumber = (TextView)v.findViewById(R.id.number);
            vPlayerPosition = (Button)v.findViewById(R.id.position);
            vPlayerGameData = (TextView)v.findViewById(R.id.gameDetails);
            vPlayerFantasyPoints = (TextView)v.findViewById(R.id.fantasyScore);
            vPlayerCard = (CardView)v.findViewById(R.id.playerCardView);

            vPlayerPosition.setOnClickListener(this);

            animShrinkToMiddle = AnimationUtils.loadAnimation(v.getContext(), R.anim.shrink_to_middle);
            animGrowFromMiddle = AnimationUtils.loadAnimation(v.getContext(), R.anim.grow_from_middle);
        }

        @Override
        public void onClick(View v) {
            if (selectedItems.get(getAdapterPosition(), false)) {
                selectedItems.delete(getAdapterPosition());
                vPlayerPosition.startAnimation(animShrinkToMiddle);
                vPlayerCard.setSelected(false);
            } else {
                selectedItems.put(getAdapterPosition(), true);
                vPlayerPosition.startAnimation(animGrowFromMiddle);
                vPlayerCard.setSelected(true);
            }
        }
    }

    public void toggleSelection(int pos) {
        if (selectedItems.get(pos, false)) {
            selectedItems.delete(pos);
        } else {
            selectedItems.put(pos,true);
        }
        notifyItemChanged(pos);
    }

    public void clearSelections() {
        selectedItems.clear();
        notifyDataSetChanged();
    }

    public int getSelectedItemCount() {
        return selectedItems.size();
    }

    public List<Integer> getSelectedItems() {
        List<Integer> items = new ArrayList<>(selectedItems.size());
        for (int i = 0; i < selectedItems.size(); i++) {
            items.add(selectedItems.keyAt(i));
        }
        return items;
    }

}

