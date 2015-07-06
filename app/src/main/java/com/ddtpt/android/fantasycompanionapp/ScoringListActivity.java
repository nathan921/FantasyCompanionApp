package com.ddtpt.android.fantasycompanionapp;

import android.app.Fragment;

/**
 * Created by e228596 on 7/6/2015.
 */
public class ScoringListActivity extends MainActivity {
    @Override
    protected Fragment createFragment() {
        return new ScoringListFragment();
    }
}
