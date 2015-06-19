package com.ddtpt.android.fantasycompanionapp;

import java.util.ArrayList;

/**
 * Created by e228596 on 6/17/2015.
 */
public class LeagueData {
    String mLeagueKey, mLeagueId, mLeagueName, mLeagueChatId;
    int mNumberOfTeams, mCurrentWeek, mStartWeek, mEndWeek;
    int mCurrentUserTeamId;

    ArrayList<TeamData> mTeams;

    public LeagueData() {
        mTeams = new ArrayList<>();
    }

    public TeamData getTeamByTeamId(int teamId) {
        for (TeamData t : mTeams) {
            if (t.getTeamId() == teamId) {
                return t;
            }
        }
        return null;
    }

    public ArrayList<TeamData> getTeams() {
        return mTeams;
    }

    public void setTeams(ArrayList<TeamData> teams) {
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
