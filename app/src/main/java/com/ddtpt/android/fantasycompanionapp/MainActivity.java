package com.ddtpt.android.fantasycompanionapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.squareup.otto.Bus;

import java.util.ArrayList;

/**
 * Created by e228596 on 6/12/2015.
 *
 * Basics:
 * 1. Change roster
 * 2. Add/Drop players
 * 3. View any team's roster
 * 4. Search for player/View Stats/Current Team
 * 5. Current Standings
 *
 * IDEAS:
 * 1.  Select 2 players at the same position and compare them to eachother using the comparison site that has expert rankings.
 *      Possibly add the ability to select more than 2 and list best to worst options?
 * 2.  Head to head screen addition
 * 3.  Chat?
 * 3.  Playoff Scenarios?
 * 4.  Some indication of the current pace of points compared to their projection
 * 5.  Historical data pulled from internet resource about playing a certain team, conditions, etc.
 * 6.  Opponent data for the same stuff as above.
 *
 */
public abstract class MainActivity extends AppCompatActivity {
    protected abstract Fragment createFragment();

    public static final String TAG = "MainActivity";

    Bus mBus;
    DataGatherUtils mDataGatherUtils;

    FloatingActionButton fab;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDataGatherUtils = new DataGatherUtils(this);

        mBus = BusProvider.getInstance();
        mBus.register(this);

        FragmentManager fm = getFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentHolder);

        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragmentHolder, fragment)
                    .commit();
        }

        setupToolbar();
        setupFab();
        setupNavigationView();
        checkAccessToken();
    }

    private void checkAccessToken() {
        if (!mDataGatherUtils.getTokenFromPrefs()) {
            mDataGatherUtils.getAccessToken();
        }
    }

    private void setupNavigationView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    }

    private void setupFab() {
        fab = (FloatingActionButton) findViewById(R.id.fab);
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.abc_btn_radio_material);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Uri uri = intent.getData();
        if (uri != null && uri.getScheme().equals("yffa")) {
            //Event bus back to the DataGatherUtils class to get the data using the
            //mProvider.retrieveAccessToken function
            mDataGatherUtils.parseAccessToken(uri);
        }

    }

    @Override
    public void onStart() {
        super.onStart();
        mDataGatherUtils.testApi();
    }
}
