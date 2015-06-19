package com.ddtpt.android.fantasycompanionapp;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by e228596 on 6/17/2015.
 */
public class DataStore {
    private static final String TAG = "DataStore";
    private static final String FILENAME = "fantasy.json";

    private LeagueData mLeague;

    private static DataStore sDataStore;
    private Context mAppContext;

    private DataStore(Context appContext) {
        mAppContext = appContext;

        //TODO: Retrieve stored data from previous instance here

    }

    public static DataStore get(Context c) {
        if (sDataStore == null) {
            sDataStore = new DataStore(c.getApplicationContext());
        }
        return sDataStore;
    }

    public LeagueData getLeague() {
        if (mLeague == null) {
            mLeague = new LeagueData();
        }
        return mLeague;
    }
}
