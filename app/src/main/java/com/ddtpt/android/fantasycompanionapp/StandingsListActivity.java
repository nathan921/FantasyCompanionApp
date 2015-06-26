package com.ddtpt.android.fantasycompanionapp;

import android.app.Fragment;

/**
 * Created by e228596 on 6/25/2015.
 */
public class StandingsListActivity  extends MainActivity{
    @Override
    protected Fragment createFragment() {
        return new StandingsListFragment();
    }
}
