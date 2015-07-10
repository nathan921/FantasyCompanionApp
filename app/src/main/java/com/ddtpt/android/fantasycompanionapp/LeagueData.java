package com.ddtpt.android.fantasycompanionapp;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by e228596 on 6/17/2015.
 */
public class LeagueData {
    private static LeagueData sLeagueData;

    JsonFactory.League mLeagueData;
    ArrayList<JsonFactory.Team> mTeams;
    JsonFactory.Scoreboard mScoreboard;
    int[] mStandings;
    JsonFactory mJsonFactory;

    private LeagueData(Context context) {
        mJsonFactory = new JsonFactory();
        mLeagueData = mJsonFactory.new League();
        mScoreboard = mJsonFactory.new Scoreboard();
        mTeams = new ArrayList<JsonFactory.Team>();
    }

    public static LeagueData get(Context c) {
        if (sLeagueData == null) {
            sLeagueData = new LeagueData(c.getApplicationContext());
        }
        return sLeagueData;
    }

    public JsonFactory.Team getTeamByTeamId(int teamId) {
        for (JsonFactory.Team t : mTeams) {
            if (t.getTeam_id().equals(teamId)) {
                return t;
            }
        }
        return null;
    }

    public void addTeam(JsonFactory.Team team) {
        mTeams.add(team);
    }

    public List<JsonFactory.Team> getTeams() {
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
