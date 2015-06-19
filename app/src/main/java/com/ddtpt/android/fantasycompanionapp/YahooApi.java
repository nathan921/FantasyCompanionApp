package com.ddtpt.android.fantasycompanionapp;

import com.google.gson.JsonElement;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by e228596 on 6/18/2015.
 *
 * 331.l.106320.t.1
 *
 * First number is the sports code based on sports league and year
 * l = league id follows
 * t = team id follows
 * p = player id follows
 * tr = transaction id follows
 * w.c. = waiver claim id follows
 * pt = pending trade id follows
 *
 *
 * USER DATA: http://fantasysports.yahooapis.com/fantasy/v2/users;use_login=1
 * ROSTER: http://fantasysports.yahooapis.com/fantasy/v2/team/223.l.431.t.9/roster/;week=current
 *
 */
public interface YahooApi {

    //TODO: need to store the values that come back from here for future calls
    @GET("/users;use_login=1")
    void getUserData(Callback<JsonElement> callback);

    @GET("/team/{id_string}/roster;week=current")
    void getCurrentWeeksRoster(@Path("id_string") String id, Callback<JsonElement> callback);

}
