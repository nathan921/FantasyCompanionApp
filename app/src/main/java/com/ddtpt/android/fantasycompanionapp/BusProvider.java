package com.ddtpt.android.fantasycompanionapp;

import com.squareup.otto.Bus;

/**
 * Created by e228596 on 6/17/2015.
 */
public class BusProvider {
    private static final Bus BUS = new Bus();

    public static Bus getInstance() {
        return BUS;
    }

    private BusProvider() {}

}
