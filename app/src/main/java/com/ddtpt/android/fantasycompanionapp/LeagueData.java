package com.ddtpt.android.fantasycompanionapp;

import java.util.ArrayList;

/**
 * Created by e228596 on 6/17/2015.
 */
public class LeagueData {

    JsonFactory.League mLeagueData;
    ArrayList<JsonFactory.Team> mTeams;

    String mLeagueKey, mLeagueId, mLeagueName, mLeagueChatId;
    int mNumberOfTeams, mCurrentWeek, mStartWeek, mEndWeek;
    int mCurrentUserTeamId;

    public LeagueData() {
        mTeams = new ArrayList<>();
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

    public String getLeagueKey() {
        return mLeagueKey;
    }

    public int getCurrentUserTeamId() {
        return mCurrentUserTeamId;
    }

    public void setCurrentUserTeamId(int currentUserTeamId) {
        mCurrentUserTeamId = currentUserTeamId;
    }

    public void setLeagueKey(String leagueKey) {
        mLeagueKey = leagueKey;
    }

    public String getLeagueId() {
        return mLeagueId;
    }

    public void setLeagueId(String leagueId) {
        mLeagueId = leagueId;
    }

    public String getLeagueName() {
        return mLeagueName;
    }

    public void setLeagueName(String leagueName) {
        mLeagueName = leagueName;
    }

    public String getLeagueChatId() {
        return mLeagueChatId;
    }

    public void setLeagueChatId(String leagueChatId) {
        mLeagueChatId = leagueChatId;
    }

    public int getNumberOfTeams() {
        return mNumberOfTeams;
    }

    public void setNumberOfTeams(int numberOfTeams) {
        mNumberOfTeams = numberOfTeams;
    }

    public int getCurrentWeek() {
        return mCurrentWeek;
    }

    public void setCurrentWeek(int currentWeek) {
        mCurrentWeek = currentWeek;
    }

    public int getStartWeek() {
        return mStartWeek;
    }

    public void setStartWeek(int startWeek) {
        mStartWeek = startWeek;
    }

    public int getEndWeek() {
        return mEndWeek;
    }

    public void setEndWeek(int endWeek) {
        mEndWeek = endWeek;
    }
}
