package com.ddtpt.android.fantasycompanionapp;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by e228596 on 6/17/2015.
 */
public class RosterListActivity extends MainActivity {

    @Override
    protected Fragment createFragment() {
        return new RosterListFragment();
    }

}
