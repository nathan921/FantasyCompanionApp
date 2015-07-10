package com.ddtpt.android.fantasycompanionapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;

/**
 * Created by e228596 on 6/17/2015.
 */
public class RosterListFragment extends Fragment {
    private JsonFactory.Team mTeam;
    private static String TAG = "RosterListFragment";
    private RecyclerView mRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //mTeam = DataStore.get(getActivity()).getLeague().getTeamByTeamId(1);
        mTeam = LeagueData.get(getActivity()).getTeamByTeamId(1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.player_roster_layout, parent, false);

        mRecyclerView = (RecyclerView)v.findViewById(R.id.rosterRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST);
        mRecyclerView.addItemDecoration(itemDecoration);

        RosterRecyclerAdapter adapter = new RosterRecyclerAdapter(mTeam.getRoster().getPlayers());
        mRecyclerView.setAdapter(adapter);

        return v;
    }


}
