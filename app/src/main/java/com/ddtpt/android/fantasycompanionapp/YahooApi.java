package com.ddtpt.android.fantasycompanionapp;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

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
 * Matt Stafford Player ID = 9265
 * Julio Jones Player ID = 24793
 *
 * USER DATA: http://fantasysports.yahooapis.com/fantasy/v2/users;use_login=1
 * ROSTER: http://fantasysports.yahooapis.com/fantasy/v2/team/223.l.431.t.9/roster/;week=current
 * SETTINGS: http://fantasysports.yahooapis.com/fantasy/v2/league/348.l.106320/settings
 *  -Includes league data, roster position counts, and stat worth
 * STANDINGS: http://fantasysports.yahooapis.com/fantasy/v2/league/348.l.106320/standings
 *  -Includes Team data, rank, wins/loses
 * SCOREBOARD: http://fantasysports.yahooapis.com/fantasy/v2/league/348.l.106320/scoreboard
 *  -Includes matchups, winner, team points and team projections
 *
 */
public interface YahooApi {

    ///fantasy/v2/RESOURCE/GAMEID.l.LEAGUEID.t.TEAMID/SUBRESOURCE/<PARAM_STRING,PARAM_VALUE>;

    //TODO: need to store the values that come back from here for future calls
    @GET("/fantasy/v2/users;use_login=1?format=json")
    void getUserData(Callback<JsonElement> callback);

    @GET("/team/{id_string}/roster;week=current")
    void getCurrentWeeksRoster(@Path("id_string") String id, Callback<JsonElement> callback);

    @GET("/fantasy/v2/league/331.l.106320/standings")
    void getStandings(Callback<JsonElement> callback);

    //Gets League Info and Scoring Values
    @GET("/fantasy/v2/league/{game_id}.l.{league_id}/settings?format=json")
    void getLeagueSettings(@Path("game_id") String game_id, @Path("league_id") String league_id, Callback<JsonElement> callback);

    @GET("/fantasy/v2/team/331.l.106320.t.1/roster/players;week=15?format=json")
    void getTeamRoster(Callback<JsonElement> callback);

    @GET("/fantasy/v2/league/331.l.106320/scoreboard;week=15?format=json")
    void getScoreboard(Callback<JsonElement> callback);

    @GET("/fantasy/v2/team/331.l.106320.t.1/matchups?format=json")
    void getMatchups(Callback<JsonElement> callback);

    @GET("/fantasy/v2/player/331.p.5479/stats?format=json")
    void getPlayerData(Callback<JsonElement> callback);
}
