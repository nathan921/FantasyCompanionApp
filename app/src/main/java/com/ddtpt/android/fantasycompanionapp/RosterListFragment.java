package com.ddtpt.android.fantasycompanionapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by e228596 on 6/17/2015.
 */
public class RosterListFragment extends Fragment {
    private TeamData mTeam;
    private static String TAG = "RosterListFragment";
    private RecyclerView mRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTeam = DataStore.get(getActivity()).getLeague().getTeamByTeamId(1);
        if (mTeam == null) {
            mTeam = new TeamData();
            mTeam.addPlayerToTeam(new PlayerData("Detlef Nguyen", "QB", "DEN @ JEW 11AM", 12, 15.35));
            mTeam.addPlayerToTeam(new PlayerData("Bill Bangbus", "WR", "ATL @ ASS 2PM", 3, 7.65));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.player_roster_layout, parent, false);

        mRecyclerView = (RecyclerView)v.findViewById(R.id.rosterRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        RosterRecyclerAdapter adapter = new RosterRecyclerAdapter(mTeam.getTeamPlayers());
        mRecyclerView.setAdapter(adapter);

        return v;
    }


}
