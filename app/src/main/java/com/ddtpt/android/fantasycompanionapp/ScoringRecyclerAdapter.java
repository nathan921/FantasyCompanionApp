package com.ddtpt.android.fantasycompanionapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;

/**
 * Created by e228596 on 7/6/2015.
 */
public class ScoringRecyclerAdapter extends RecyclerView.Adapter<ScoringRecyclerAdapter.ScoringViewHolder> {
    private HashMap<Integer, String> mScoreValueList;

    public ScoringRecyclerAdapter(HashMap<Integer, String> values) {
        mScoreValueList = values;
    }


    @Override
    public ScoringRecyclerAdapter.ScoringViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ScoringRecyclerAdapter.ScoringViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mScoreValueList.size();
    }

    public static class ScoringViewHolder extends RecyclerView.ViewHolder {

        public ScoringViewHolder(View itemView) {
            super(itemView);
        }
    }
}
