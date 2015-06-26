package com.ddtpt.android.fantasycompanionapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by e228596 on 6/25/2015.
 */
public class StandingsListFragment extends Fragment {
    private RecyclerView mRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.player_roster_layout, parent, false);

        mRecyclerView = (RecyclerView)v.findViewById(R.id.standingsRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        RosterRecyclerAdapter adapter = new StandingsRecyclerAdapter();
        mRecyclerView.setAdapter(adapter);

        return v;
    }
}

