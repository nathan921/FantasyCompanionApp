package com.ddtpt.android.fantasycompanionapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;

/**
 * Created by e228596 on 7/6/2015.
 */
public class ScoringListFragment extends Fragment {
    RecyclerView mRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_scoring, parent, false);

        mRecyclerView = (RecyclerView)v.findViewById(R.id.scoringRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        ScoringRecyclerAdapter adapter = new ScoringRecyclerAdapter(new HashMap<Integer, String>());
        mRecyclerView.setAdapter(adapter);

        return v;
    }


}
