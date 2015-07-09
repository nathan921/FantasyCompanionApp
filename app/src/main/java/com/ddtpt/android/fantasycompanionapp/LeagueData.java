package com.ddtpt.android.fantasycompanionapp;

import java.util.ArrayList;

/**
 * Created by e228596 on 6/17/2015.
 */
public class LeagueData {

    JsonFactory.League mLeagueData;
    ArrayList<JsonFactory.Team> mTeams;
    JsonFactory.Scoreboard mScoreboard;
    int[] mStandings;
    JsonFactory mJsonFactory;

    public LeagueData() {
        mJsonFactory = new JsonFactory();
        mLeagueData = mJsonFactory.new League();
        mTeams = new ArrayList<>();
        mScoreboard = mJsonFactory.new Scoreboard();
    }

    public JsonFactory.Team getTeamByTeamId(int teamId) {
        for (JsonFactory.Team t : mTeams) {
            if (t.getTeam_id().equals(teamId)) {
                return t;
            }
        }
        return null;
    }

    public ArrayList<JsonFactory.Team> getTeams() {
        return mTeams;
    }

    public void setTeams(ArrayList<JsonFactory.Team> teams) {
        mTeams = teams;
    }

    public void setStandings(int[] stand) {
        mStandings = stand;
    }

    public void setIndividualStanding(int teamId, int pos) {
        mStandings[pos] = teamId;
    }
}
