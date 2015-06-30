package com.ddtpt.android.fantasycompanionapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by e228596 on 6/25/2015.
 */
public class StandingsListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private static final String TAG = "StandingsListFragment";
    private ArrayList<TeamData> mOwnerData;
    private DataGatherUtils mDataGatherUtils;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mOwnerData = new ArrayList<>();
        mDataGatherUtils = new DataGatherUtils(getActivity());

        TeamData temp = new TeamData();
        temp.setRecord("12-3-0");
        temp.setTeamOwner("Nathan Lamar");
        temp.setTeamName("The Nguyens");
        temp.setTotalPoints(1183.23);

        TeamData temp2 = new TeamData();
        temp2.setRecord("11-4-0");
        temp2.setTeamOwner("Emerson Fitapaldi");
        temp2.setTeamName("Nate Top Joe Bottom");
        temp2.setTotalPoints(1045.99);

        TeamData temp3 = new TeamData();
        temp3.setRecord("10-5-0");
        temp3.setTeamOwner("Detlef Nguyenbergstein");
        temp3.setTeamName("The Ass Douches");
        temp3.setTotalPoints(985.22);

        mOwnerData.add(temp);
        mOwnerData.add(temp2);
        mOwnerData.add(temp3);

        fetchStandingsData();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.standings_layout, parent, false);

        mRecyclerView = (RecyclerView)v.findViewById(R.id.standingsRecyclerView);
        mRecyclerView.setHasFixedSize(true);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST);
        mRecyclerView.addItemDecoration(itemDecoration);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        StandingsRecyclerAdapter adapter = new StandingsRecyclerAdapter(mOwnerData);
        mRecyclerView.setAdapter(adapter);

        return v;
    }

    public void fetchStandingsData() {

    }
}

