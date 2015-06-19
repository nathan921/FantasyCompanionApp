package com.ddtpt.android.fantasycompanionapp;

import java.util.ArrayList;

/**
 * Created by e228596 on 6/17/2015.
 */
public class TeamData {
    String mTeamName, mTeamOwner, mTeamKey;
    int mWaiverPriority, mNumberOfMoves, mNumberOfTrades, mTeamId;
    boolean mHasClinchedPlayoffs;

    ArrayList<PlayerData> mTeam;

    public ArrayList<PlayerData> getTeamPlayers() {
        return mTeam;
    }

    public void addPlayerToTeam(PlayerData player) {
        mTeam.add(player);
    }

    public String getTeamName() {
        return mTeamName;
    }

    public void setTeamName(String teamName) {
        mTeamName = teamName;
    }

    public String getTeamOwner() {
        return mTeamOwner;
    }

    public void setTeamOwner(String teamOwner) {
        mTeamOwner = teamOwner;
    }

    public String getTeamKey() {
        return mTeamKey;
    }

    public void setTeamKey(String teamKey) {
        mTeamKey = teamKey;
    }

    public int getWaiverPriority() {
        return mWaiverPriority;
    }

    public void setWaiverPriority(int waiverPriority) {
        mWaiverPriority = waiverPriority;
    }

    public int getNumberOfMoves() {
        return mNumberOfMoves;
    }

    public void setNumberOfMoves(int numberOfMoves) {
        mNumberOfMoves = numberOfMoves;
    }

    public int getNumberOfTrades() {
        return mNumberOfTrades;
    }

    public void setNumberOfTrades(int numberOfTrades) {
        mNumberOfTrades = numberOfTrades;
    }

    public int getTeamId() {
        return mTeamId;
    }

    public void setTeamId(int teamId) {
        mTeamId = teamId;
    }

    public boolean isHasClinchedPlayoffs() {
        return mHasClinchedPlayoffs;
    }

    public void setHasClinchedPlayoffs(boolean hasClinchedPlayoffs) {
        mHasClinchedPlayoffs = hasClinchedPlayoffs;
    }
}
