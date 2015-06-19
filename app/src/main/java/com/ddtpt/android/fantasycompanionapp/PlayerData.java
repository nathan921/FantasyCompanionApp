package com.ddtpt.android.fantasycompanionapp;

import java.util.UUID;

/**
 * Created by e228596 on 6/17/2015.
 */
public class PlayerData {
    //TODO: Change to the Yahoo Assigned ID
    UUID mId;
    String mPlayerName, mPlayerPosition, mPlayerGameDetails;
    int mPlayerNumber;
    double mPlayerFantasyPoints;

    public PlayerData() {

    }

    public PlayerData(String name, String pos, String details, int number, double points) {
        mId = UUID.randomUUID();
        mPlayerName = name;
        mPlayerFantasyPoints = points;
        mPlayerGameDetails = details;
        mPlayerNumber = number;
        mPlayerPosition = pos;
    }

    public String getPlayerName() {
        return mPlayerName;
    }

    public void setPlayerName(String name) {
        mPlayerName = name;
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        this.mId = id;
    }

    public int getPlayerNumber() {
        return mPlayerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        mPlayerNumber = playerNumber;
    }

    public String getPlayerPosition() {
        return mPlayerPosition;
    }

    public void setPlayerPosition(String playerPosition) {
        mPlayerPosition = playerPosition;
    }

    public String getPlayerGameDetails() {
        return mPlayerGameDetails;
    }

    public void setPlayerGameDetails(String playerGameDetails) {
        mPlayerGameDetails = playerGameDetails;
    }

    public double getPlayerFantasyPoints() {
        return mPlayerFantasyPoints;
    }

    public void setPlayerFantastyPoints(double playerFantasyPoints) {
        mPlayerFantasyPoints = playerFantasyPoints;
    }
}
