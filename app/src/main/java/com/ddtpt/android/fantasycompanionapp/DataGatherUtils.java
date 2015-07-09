package com.ddtpt.android.fantasycompanionapp;

import com.ddtpt.android.fantasycompanionapp.JsonFactory;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.squareup.otto.Bus;

import oauth.signpost.commonshttp.CommonsHttpOAuthProvider;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.exception.OAuthNotAuthorizedException;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;
import retrofit.client.Response;

/**
 * Created by e228596 on 6/17/2015.
 * Authorization: OAuth realm="example",
     oauth_consumer_key="9djdj82h48djs9d2",
     oauth_token="kkk9d7dh3k39sjv7",
     oauth_signature_method="HMAC-SHA1",
     oauth_timestamp="137131201",
     oauth_nonce="7d8f3e4a",
     oauth_signature="bYT5CMsGcbgUdFHObYMEfcx6bsw%3D"
 */
public class DataGatherUtils {
    private static final String TAG = "DataGatherUtils";

    private static final String SECRET = "oauth_secret";
    private static final String TOKEN = "oauth_token";

    private static final String OAUTH_SIGNATURE_METHOD = "oauth_signature_method";
    private static final String SIGNATURE_METHOD = "HMAC-SHA1";
    private static final String REALM = "realm";

    private static final String OAUTH_TIMESTAMP = "oauth_timestamp";
    private static final String OAUTH_NONCE = "oauth_nonce";
    private static final String OAUTH_SIGNATURE = "oauth_signature";
    private static final String OAUTH_VERSION = "oauth_version";

    private static final String SESSION = "oauth_session_handle";
    private static final String VERIFIER = "oauth_verifier";

    private static final String BASE_URL = "http://fantasysports.yahooapis.com";
    private static final String GET_TOKEN = "https://api.login.yahoo.com/oauth/v2/get_token";

    private static final String OAUTH_CONSUMER_KEY = "oauth_consumer_key";
    private static final String CONSUMER_KEY = "dj0yJmk9RjVUYUZNc1piMzVRJmQ9WVdrOVNGUnJkMFZFTldVbWNHbzlNQS0tJnM9Y29uc3VtZXJzZWNyZXQmeD02YQ--";
    private static final String CONSUMER_SECRET = "7c5d77c23d2c2a4c2c117bc846e392c5fa7a4697";

    private static final String GET_REQUEST_TOKEN = "get_request_token";
    private static final String GET_ACCESS_TOKEN = "get_access_token";

    private static final String GAME = "game/";
    private static final String USER = "users;use_login=1";
    private static final String GAME_KEYS = "game_keys=";
    private static final String JSON_FORMAT = "?format=json";

    private static final String METADATA = "metadata";
    private static final String LEAGUES = "leagues";
    private static final String LEAGUE = "league";
    private static final String PLAYER = "player";
    private static final String PLAYERS = "players";
    private static final String GAME_WEEKS = "game_weeks";
    private static final String STAT_CATEGORIES = "stat_categories";
    private static final String POSITION_TYPES = "position_types";
    private static final String ROSTER_POSITIONS = "roster_positions";
    private static final String SETTINGS = "settings";
    private static final String STANDINGS = "standings";
    private static final String SCOREBOARD = "scoreboard";
    private static final String TEAMS = "teams";
    private static final String TRANSACTIONS = "transactions";
    private static final String GAMES = "games";
    private static final String TEAM = "team";
    private static final String ROSTER = "roster";
    private static final String STATS = "stats";
    private static final String USER_DATA = "user_data";
    private static final String USER_GAMES = "user_games";
    private static final String TEAM_KEY = "team_key";
    private static final String LEAGUE_KEY = "league_key";
    private static final String GAME_KEY = "game_key";
    private static final String USER_TEAMS = "user_teams";
    private static final String TEAM_STATS = "team_stats";
    private static final String PLAYER_STATS = "player_stats";
    private static final String MATCHUPS = "matchups";

    public static final String ROSTER_PLAYERS_JSON = "{\"fantasy_content\":{\"xml:lang\":\"en-US\",\"yahoo:uri\":\"/fantasy/v2/team/331.l.106320.t.1/roster/players;week=15\",\"team\":[[{\"team_key\":\"331.l.106320.t.1\"},{\"team_id\":\"1\"},{\"name\":\"Crusher of Dreams\"},{\"is_owned_by_current_login\":1},{\"url\":\"http://football.fantasysports.yahoo.com/archive/nfl/2014/106320/1\"},{\"team_logos\":[{\"team_logo\":{\"size\":\"large\",\"url\":\"https://i.imgur-ysports.com/BjKojTjy.jpg\"}}]},[],{\"waiver_priority\":9},[],{\"number_of_moves\":\"28\"},{\"number_of_trades\":0},{\"roster_adds\":{\"coverage_type\":\"week\",\"coverage_value\":\"17\",\"value\":\"0\"}},{\"clinched_playoffs\":1},{\"league_scoring_type\":\"head\"},{\"managers\":[{\"manager\":{\"manager_id\":\"1\",\"nickname\":\"Nathan\",\"guid\":\"TDJZVZ2P7ATEP64L37ZTW2IO7I\",\"is_commissioner\":\"1\",\"is_current_login\":\"1\",\"email\":\"detlefmagoo@yahoo.com\",\"image_url\":\"https://s.yimg.com/dh/ap/social/profile/profile_b64.png\"}}]}],{\"roster\":{\"coverage_type\":\"week\",\"week\":\"16\",\"is_editable\":0,\"0\":{\"players\":{\"0\":{\"player\":[[{\"player_key\":\"331.p.9265\"},{\"player_id\":\"9265\"},{\"name\":{\"full\":\"Matthew Stafford\",\"first\":\"Matthew\",\"last\":\"Stafford\",\"ascii_first\":\"Matthew\",\"ascii_last\":\"Stafford\"}},{\"editorial_player_key\":\"nfl.p.9265\"},{\"editorial_team_key\":\"nfl.t.8\"},{\"editorial_team_full_name\":\"Detroit Lions\"},{\"editorial_team_abbr\":\"Det\"},{\"bye_weeks\":{\"week\":\"9\"}},{\"uniform_number\":\"9\"},{\"display_position\":\"QB\"},{\"headshot\":{\"url\":\"http://l.yimg.com/iu/api/res/1.2/Gan7fTx1Bh2_DjFuIErYEg--/YXBwaWQ9c2hhcmVkO2NoPTIzMzY7Y3I9MTtjdz0xNzkwO2R4PTg1NztkeT0wO2ZpPXVsY3JvcDtoPTYwO3E9MTAwO3c9NDY-/https://s.yimg.com/xe/i/us/sp/v/nfl_cutout/players_l/20141101/9265.png\",\"size\":\"small\"},\"image_url\":\"http://l.yimg.com/iu/api/res/1.2/Gan7fTx1Bh2_DjFuIErYEg--/YXBwaWQ9c2hhcmVkO2NoPTIzMzY7Y3I9MTtjdz0xNzkwO2R4PTg1NztkeT0wO2ZpPXVsY3JvcDtoPTYwO3E9MTAwO3c9NDY-/https://s.yimg.com/xe/i/us/sp/v/nfl_cutout/players_l/20141101/9265.png\"},{\"is_undroppable\":\"0\"},{\"position_type\":\"O\"},{\"eligible_positions\":[{\"position\":\"QB\"}]},[],[]],{\"selected_position\":[{\"coverage_type\":\"week\",\"week\":\"16\"},{\"position\":\"QB\"}]},[],{\"is_editable\":0}]},\"1\":{\"player\":[[{\"player_key\":\"331.p.9283\"},{\"player_id\":\"9283\"},{\"name\":{\"full\":\"Jeremy Maclin\",\"first\":\"Jeremy\",\"last\":\"Maclin\",\"ascii_first\":\"Jeremy\",\"ascii_last\":\"Maclin\"}},{\"editorial_player_key\":\"nfl.p.9283\"},{\"editorial_team_key\":\"nfl.t.12\"},{\"editorial_team_full_name\":\"Kansas City Chiefs\"},{\"editorial_team_abbr\":\"KC\"},{\"bye_weeks\":{\"week\":\"6\"}},{\"uniform_number\":\"19\"},{\"display_position\":\"WR\"},{\"headshot\":{\"url\":\"http://l.yimg.com/iu/api/res/1.2/04gZuArbTHIdponfVNoQsA--/YXBwaWQ9c2hhcmVkO2NoPTIzMzY7Y3I9MTtjdz0xNzkwO2R4PTg1NztkeT0wO2ZpPXVsY3JvcDtoPTYwO3E9MTAwO3c9NDY-/https://s.yimg.com/xe/i/us/sp/v/nfl_cutout/players_l/20141101/9283.png\",\"size\":\"small\"},\"image_url\":\"http://l.yimg.com/iu/api/res/1.2/04gZuArbTHIdponfVNoQsA--/YXBwaWQ9c2hhcmVkO2NoPTIzMzY7Y3I9MTtjdz0xNzkwO2R4PTg1NztkeT0wO2ZpPXVsY3JvcDtoPTYwO3E9MTAwO3c9NDY-/https://s.yimg.com/xe/i/us/sp/v/nfl_cutout/players_l/20141101/9283.png\"},{\"is_undroppable\":\"0\"},{\"position_type\":\"O\"},{\"eligible_positions\":[{\"position\":\"WR\"}]},{\"has_player_notes\":1},[]],{\"selected_position\":[{\"coverage_type\":\"week\",\"week\":\"16\"},{\"position\":\"WR\"}]},[],{\"is_editable\":0}]},\"2\":{\"player\":[[{\"player_key\":\"331.p.26561\"},{\"player_id\":\"26561\"},{\"name\":{\"full\":\"Josh Gordon\",\"first\":\"Josh\",\"last\":\"Gordon\",\"ascii_first\":\"Josh\",\"ascii_last\":\"Gordon\"}},{\"status\":\"O\"},{\"editorial_player_key\":\"nfl.p.26561\"},{\"editorial_team_key\":\"nfl.t.5\"},{\"editorial_team_full_name\":\"Cleveland Browns\"},{\"editorial_team_abbr\":\"Cle\"},{\"bye_weeks\":{\"week\":\"4\"}},{\"uniform_number\":\"12\"},{\"display_position\":\"WR\"},{\"headshot\":{\"url\":\"http://l.yimg.com/iu/api/res/1.2/IyR9luGnP1AqUMaIrP7jXQ--/YXBwaWQ9c2hhcmVkO2NoPTIzMzY7Y3I9MTtjdz0xNzkwO2R4PTg1NztkeT0wO2ZpPXVsY3JvcDtoPTYwO3E9MTAwO3c9NDY-/https://s.yimg.com/xe/i/us/sp/v/nfl_cutout/players_l/20141101/26561.png\",\"size\":\"small\"},\"image_url\":\"http://l.yimg.com/iu/api/res/1.2/IyR9luGnP1AqUMaIrP7jXQ--/YXBwaWQ9c2hhcmVkO2NoPTIzMzY7Y3I9MTtjdz0xNzkwO2R4PTg1NztkeT0wO2ZpPXVsY3JvcDtoPTYwO3E9MTAwO3c9NDY-/https://s.yimg.com/xe/i/us/sp/v/nfl_cutout/players_l/20141101/26561.png\"},{\"is_undroppable\":\"0\"},{\"position_type\":\"O\"},{\"eligible_positions\":[{\"position\":\"WR\"}]},{\"has_player_notes\":1},[]],{\"selected_position\":[{\"coverage_type\":\"week\",\"week\":\"16\"},{\"position\":\"WR\"}]},[],{\"is_editable\":0}]},\"3\":{\"player\":[[{\"player_key\":\"331.p.24793\"},{\"player_id\":\"24793\"},{\"name\":{\"full\":\"Julio Jones\",\"first\":\"Julio\",\"last\":\"Jones\",\"ascii_first\":\"Julio\",\"ascii_last\":\"Jones\"}},{\"editorial_player_key\":\"nfl.p.24793\"},{\"editorial_team_key\":\"nfl.t.1\"},{\"editorial_team_full_name\":\"Atlanta Falcons\"},{\"editorial_team_abbr\":\"Atl\"},{\"bye_weeks\":{\"week\":\"9\"}},{\"uniform_number\":\"11\"},{\"display_position\":\"WR\"},{\"headshot\":{\"url\":\"http://l.yimg.com/iu/api/res/1.2/mI7ei6TYeeerRu1Nv6n6yg--/YXBwaWQ9c2hhcmVkO2NoPTIzMzY7Y3I9MTtjdz0xNzkwO2R4PTg1NztkeT0wO2ZpPXVsY3JvcDtoPTYwO3E9MTAwO3c9NDY-/https://s.yimg.com/xe/i/us/sp/v/nfl_cutout/players_l/20141101/24793.png\",\"size\":\"small\"},\"image_url\":\"http://l.yimg.com/iu/api/res/1.2/mI7ei6TYeeerRu1Nv6n6yg--/YXBwaWQ9c2hhcmVkO2NoPTIzMzY7Y3I9MTtjdz0xNzkwO2R4PTg1NztkeT0wO2ZpPXVsY3JvcDtoPTYwO3E9MTAwO3c9NDY-/https://s.yimg.com/xe/i/us/sp/v/nfl_cutout/players_l/20141101/24793.png\"},{\"is_undroppable\":\"0\"},{\"position_type\":\"O\"},{\"eligible_positions\":[{\"position\":\"WR\"}]},[],[]],{\"selected_position\":[{\"coverage_type\":\"week\",\"week\":\"16\"},{\"position\":\"WR\"}]},[],{\"is_editable\":0}]},\"4\":{\"player\":[[{\"player_key\":\"331.p.26684\"},{\"player_id\":\"26684\"},{\"name\":{\"full\":\"Eddie Lacy\",\"first\":\"Eddie\",\"last\":\"Lacy\",\"ascii_first\":\"Eddie\",\"ascii_last\":\"Lacy\"}},{\"editorial_player_key\":\"nfl.p.26684\"},{\"editorial_team_key\":\"nfl.t.9\"},{\"editorial_team_full_name\":\"Green Bay Packers\"},{\"editorial_team_abbr\":\"GB\"},{\"bye_weeks\":{\"week\":\"9\"}},{\"uniform_number\":\"27\"},{\"display_position\":\"RB\"},{\"headshot\":{\"url\":\"http://l.yimg.com/iu/api/res/1.2/ZKQ8l0Lp6rtU.zmEHi48dw--/YXBwaWQ9c2hhcmVkO2NoPTIzMzY7Y3I9MTtjdz0xNzkwO2R4PTg1NztkeT0wO2ZpPXVsY3JvcDtoPTYwO3E9MTAwO3c9NDY-/https://s.yimg.com/xe/i/us/sp/v/nfl_cutout/players_l/20141101/26684.png\",\"size\":\"small\"},\"image_url\":\"http://l.yimg.com/iu/api/res/1.2/ZKQ8l0Lp6rtU.zmEHi48dw--/YXBwaWQ9c2hhcmVkO2NoPTIzMzY7Y3I9MTtjdz0xNzkwO2R4PTg1NztkeT0wO2ZpPXVsY3JvcDtoPTYwO3E9MTAwO3c9NDY-/https://s.yimg.com/xe/i/us/sp/v/nfl_cutout/players_l/20141101/26684.png\"},{\"is_undroppable\":\"0\"},{\"position_type\":\"O\"},{\"eligible_positions\":[{\"position\":\"RB\"}]},[],[]],{\"selected_position\":[{\"coverage_type\":\"week\",\"week\":\"16\"},{\"position\":\"RB\"}]},[],{\"is_editable\":0}]},\"5\":{\"player\":[[{\"player_key\":\"331.p.24262\"},{\"player_id\":\"24262\"},{\"name\":{\"full\":\"Joique Bell\",\"first\":\"Joique\",\"last\":\"Bell\",\"ascii_first\":\"Joique\",\"ascii_last\":\"Bell\"}},{\"status\":\"O\"},{\"editorial_player_key\":\"nfl.p.24262\"},{\"editorial_team_key\":\"nfl.t.8\"},{\"editorial_team_full_name\":\"Detroit Lions\"},{\"editorial_team_abbr\":\"Det\"},{\"bye_weeks\":{\"week\":\"9\"}},{\"uniform_number\":\"35\"},{\"display_position\":\"RB\"},{\"headshot\":{\"url\":\"http://l.yimg.com/iu/api/res/1.2/Oyv9zVDo0KtEybJ.KGMGcg--/YXBwaWQ9c2hhcmVkO2NoPTIzMzY7Y3I9MTtjdz0xNzkwO2R4PTg1NztkeT0wO2ZpPXVsY3JvcDtoPTYwO3E9MTAwO3c9NDY-/https://s.yimg.com/xe/i/us/sp/v/nfl_cutout/players_l/20141101/24262.png\",\"size\":\"small\"},\"image_url\":\"http://l.yimg.com/iu/api/res/1.2/Oyv9zVDo0KtEybJ.KGMGcg--/YXBwaWQ9c2hhcmVkO2NoPTIzMzY7Y3I9MTtjdz0xNzkwO2R4PTg1NztkeT0wO2ZpPXVsY3JvcDtoPTYwO3E9MTAwO3c9NDY-/https://s.yimg.com/xe/i/us/sp/v/nfl_cutout/players_l/20141101/24262.png\"},{\"is_undroppable\":\"0\"},{\"position_type\":\"O\"},{\"eligible_positions\":[{\"position\":\"RB\"}]},{\"has_player_notes\":1},[]],{\"selected_position\":[{\"coverage_type\":\"week\",\"week\":\"16\"},{\"position\":\"RB\"}]},[],{\"is_editable\":0}]},\"6\":{\"player\":[[{\"player_key\":\"331.p.26708\"},{\"player_id\":\"26708\"},{\"name\":{\"full\":\"Jordan Reed\",\"first\":\"Jordan\",\"last\":\"Reed\",\"ascii_first\":\"Jordan\",\"ascii_last\":\"Reed\"}},{\"editorial_player_key\":\"nfl.p.26708\"},{\"editorial_team_key\":\"nfl.t.28\"},{\"editorial_team_full_name\":\"Washington Redskins\"},{\"editorial_team_abbr\":\"Was\"},{\"bye_weeks\":{\"week\":\"10\"}},{\"uniform_number\":\"86\"},{\"display_position\":\"TE\"},{\"headshot\":{\"url\":\"http://l.yimg.com/iu/api/res/1.2/dWjOgdHdS9bOjtkGUuk9sg--/YXBwaWQ9c2hhcmVkO2NoPTIzMzY7Y3I9MTtjdz0xNzkwO2R4PTg1NztkeT0wO2ZpPXVsY3JvcDtoPTYwO3E9MTAwO3c9NDY-/https://s.yimg.com/xe/i/us/sp/v/nfl_cutout/players_l/20141101/26708.png\",\"size\":\"small\"},\"image_url\":\"http://l.yimg.com/iu/api/res/1.2/dWjOgdHdS9bOjtkGUuk9sg--/YXBwaWQ9c2hhcmVkO2NoPTIzMzY7Y3I9MTtjdz0xNzkwO2R4PTg1NztkeT0wO2ZpPXVsY3JvcDtoPTYwO3E9MTAwO3c9NDY-/https://s.yimg.com/xe/i/us/sp/v/nfl_cutout/players_l/20141101/26708.png\"},{\"is_undroppable\":\"0\"},{\"position_type\":\"O\"},{\"eligible_positions\":[{\"position\":\"TE\"}]},[],[]],{\"selected_position\":[{\"coverage_type\":\"week\",\"week\":\"16\"},{\"position\":\"TE\"}]},[],{\"is_editable\":0}]},\"7\":{\"player\":[[{\"player_key\":\"331.p.27618\"},{\"player_id\":\"27618\"},{\"name\":{\"full\":\"Donte Moncrief\",\"first\":\"Donte\",\"last\":\"Moncrief\",\"ascii_first\":\"Donte\",\"ascii_last\":\"Moncrief\"}},{\"editorial_player_key\":\"nfl.p.27618\"},{\"editorial_team_key\":\"nfl.t.11\"},{\"editorial_team_full_name\":\"Indianapolis Colts\"},{\"editorial_team_abbr\":\"Ind\"},{\"bye_weeks\":{\"week\":\"10\"}},{\"uniform_number\":\"10\"},{\"display_position\":\"WR\"},{\"headshot\":{\"url\":\"http://l.yimg.com/iu/api/res/1.2/zOxHIjVHpf35RYHatEE7Kg--/YXBwaWQ9c2hhcmVkO2NoPTIzMzY7Y3I9MTtjdz0xNzkwO2R4PTg1NztkeT0wO2ZpPXVsY3JvcDtoPTYwO3E9MTAwO3c9NDY-/https://s.yimg.com/xe/i/us/sp/v/nfl_cutout/players_l/20141101/27618.png\",\"size\":\"small\"},\"image_url\":\"http://l.yimg.com/iu/api/res/1.2/zOxHIjVHpf35RYHatEE7Kg--/YXBwaWQ9c2hhcmVkO2NoPTIzMzY7Y3I9MTtjdz0xNzkwO2R4PTg1NztkeT0wO2ZpPXVsY3JvcDtoPTYwO3E9MTAwO3c9NDY-/https://s.yimg.com/xe/i/us/sp/v/nfl_cutout/players_l/20141101/27618.png\"},{\"is_undroppable\":\"0\"},{\"position_type\":\"O\"},{\"eligible_positions\":[{\"position\":\"WR\"}]},[],[]],{\"selected_position\":[{\"coverage_type\":\"week\",\"week\":\"16\"},{\"position\":\"BN\"}]},[],{\"is_editable\":0}]},\"8\":{\"player\":[[{\"player_key\":\"331.p.8063\"},{\"player_id\":\"8063\"},{\"name\":{\"full\":\"Fred Jackson\",\"first\":\"Fred\",\"last\":\"Jackson\",\"ascii_first\":\"Fred\",\"ascii_last\":\"Jackson\"}},{\"editorial_player_key\":\"nfl.p.8063\"},{\"editorial_team_key\":\"nfl.t.2\"},{\"editorial_team_full_name\":\"Buffalo Bills\"},{\"editorial_team_abbr\":\"Buf\"},{\"bye_weeks\":{\"week\":\"9\"}},{\"uniform_number\":\"22\"},{\"display_position\":\"RB\"},{\"headshot\":{\"url\":\"http://l.yimg.com/iu/api/res/1.2/..JEw8kqECeo.9g9lG3oOw--/YXBwaWQ9c2hhcmVkO2NoPTIzMzY7Y3I9MTtjdz0xNzkwO2R4PTg1NztkeT0wO2ZpPXVsY3JvcDtoPTYwO3E9MTAwO3c9NDY-/https://s.yimg.com/xe/i/us/sp/v/nfl_cutout/players_l/20141101/8063.png\",\"size\":\"small\"},\"image_url\":\"http://l.yimg.com/iu/api/res/1.2/..JEw8kqECeo.9g9lG3oOw--/YXBwaWQ9c2hhcmVkO2NoPTIzMzY7Y3I9MTtjdz0xNzkwO2R4PTg1NztkeT0wO2ZpPXVsY3JvcDtoPTYwO3E9MTAwO3c9NDY-/https://s.yimg.com/xe/i/us/sp/v/nfl_cutout/players_l/20141101/8063.png\"},{\"is_undroppable\":\"0\"},{\"position_type\":\"O\"},{\"eligible_positions\":[{\"position\":\"RB\"}]},[],[]],{\"selected_position\":[{\"coverage_type\":\"week\",\"week\":\"16\"},{\"position\":\"BN\"}]},[],{\"is_editable\":0}]},\"9\":{\"player\":[[{\"player_key\":\"331.p.8826\"},{\"player_id\":\"8826\"},{\"name\":{\"full\":\"DeSean Jackson\",\"first\":\"DeSean\",\"last\":\"Jackson\",\"ascii_first\":\"DeSean\",\"ascii_last\":\"Jackson\"}},{\"editorial_player_key\":\"nfl.p.8826\"},{\"editorial_team_key\":\"nfl.t.28\"},{\"editorial_team_full_name\":\"Washington Redskins\"},{\"editorial_team_abbr\":\"Was\"},{\"bye_weeks\":{\"week\":\"10\"}},{\"uniform_number\":\"11\"},{\"display_position\":\"WR\"},{\"headshot\":{\"url\":\"http://l.yimg.com/iu/api/res/1.2/eHWX6MgMZI8MByFx5.e5rA--/YXBwaWQ9c2hhcmVkO2NoPTIzMzY7Y3I9MTtjdz0xNzkwO2R4PTg1NztkeT0wO2ZpPXVsY3JvcDtoPTYwO3E9MTAwO3c9NDY-/https://s.yimg.com/xe/i/us/sp/v/nfl_cutout/players_l/20141101/8826.png\",\"size\":\"small\"},\"image_url\":\"http://l.yimg.com/iu/api/res/1.2/eHWX6MgMZI8MByFx5.e5rA--/YXBwaWQ9c2hhcmVkO2NoPTIzMzY7Y3I9MTtjdz0xNzkwO2R4PTg1NztkeT0wO2ZpPXVsY3JvcDtoPTYwO3E9MTAwO3c9NDY-/https://s.yimg.com/xe/i/us/sp/v/nfl_cutout/players_l/20141101/8826.png\"},{\"is_undroppable\":\"0\"},{\"position_type\":\"O\"},{\"eligible_positions\":[{\"position\":\"WR\"}]},[],[]],{\"selected_position\":[{\"coverage_type\":\"week\",\"week\":\"16\"},{\"position\":\"BN\"}]},[],{\"is_editable\":0}]},\"10\":{\"player\":[[{\"player_key\":\"331.p.27567\"},{\"player_id\":\"27567\"},{\"name\":{\"full\":\"Marqise Lee\",\"first\":\"Marqise\",\"last\":\"Lee\",\"ascii_first\":\"Marqise\",\"ascii_last\":\"Lee\"}},{\"editorial_player_key\":\"nfl.p.27567\"},{\"editorial_team_key\":\"nfl.t.30\"},{\"editorial_team_full_name\":\"Jacksonville Jaguars\"},{\"editorial_team_abbr\":\"Jax\"},{\"bye_weeks\":{\"week\":\"11\"}},{\"uniform_number\":\"11\"},{\"display_position\":\"WR\"},{\"headshot\":{\"url\":\"http://l.yimg.com/iu/api/res/1.2/Nv5KyJSGcR7mIdtVO.7uWA--/YXBwaWQ9c2hhcmVkO2NoPTIzMzY7Y3I9MTtjdz0xNzkwO2R4PTg1NztkeT0wO2ZpPXVsY3JvcDtoPTYwO3E9MTAwO3c9NDY-/https://s.yimg.com/xe/i/us/sp/v/nfl_cutout/players_l/20141101/27567.png\",\"size\":\"small\"},\"image_url\":\"http://l.yimg.com/iu/api/res/1.2/Nv5KyJSGcR7mIdtVO.7uWA--/YXBwaWQ9c2hhcmVkO2NoPTIzMzY7Y3I9MTtjdz0xNzkwO2R4PTg1NztkeT0wO2ZpPXVsY3JvcDtoPTYwO3E9MTAwO3c9NDY-/https://s.yimg.com/xe/i/us/sp/v/nfl_cutout/players_l/20141101/27567.png\"},{\"is_undroppable\":\"0\"},{\"position_type\":\"O\"},{\"eligible_positions\":[{\"position\":\"WR\"}]},{\"has_player_notes\":1},[]],{\"selected_position\":[{\"coverage_type\":\"week\",\"week\":\"16\"},{\"position\":\"BN\"}]},[],{\"is_editable\":0}]},\"11\":{\"player\":[[{\"player_key\":\"331.p.23996\"},{\"player_id\":\"23996\"},{\"name\":{\"full\":\"Jermaine Gresham\",\"first\":\"Jermaine\",\"last\":\"Gresham\",\"ascii_first\":\"Jermaine\",\"ascii_last\":\"Gresham\"}},{\"editorial_player_key\":\"nfl.p.23996\"},{\"editorial_team_key\":\"nfl.t.4\"},{\"editorial_team_full_name\":\"Cincinnati Bengals\"},{\"editorial_team_abbr\":\"Cin\"},{\"bye_weeks\":{\"week\":\"4\"}},{\"uniform_number\":\"84\"},{\"display_position\":\"TE\"},{\"headshot\":{\"url\":\"http://l.yimg.com/iu/api/res/1.2/aFNVarl3qjJuDEXls6hXlQ--/YXBwaWQ9c2hhcmVkO2NoPTIzMzY7Y3I9MTtjdz0xNzkwO2R4PTg1NztkeT0wO2ZpPXVsY3JvcDtoPTYwO3E9MTAwO3c9NDY-/https://s.yimg.com/xe/i/us/sp/v/nfl_cutout/players_l/20141101/23996.png\",\"size\":\"small\"},\"image_url\":\"http://l.yimg.com/iu/api/res/1.2/aFNVarl3qjJuDEXls6hXlQ--/YXBwaWQ9c2hhcmVkO2NoPTIzMzY7Y3I9MTtjdz0xNzkwO2R4PTg1NztkeT0wO2ZpPXVsY3JvcDtoPTYwO3E9MTAwO3c9NDY-/https://s.yimg.com/xe/i/us/sp/v/nfl_cutout/players_l/20141101/23996.png\"},{\"is_undroppable\":\"0\"},{\"position_type\":\"O\"},{\"eligible_positions\":[{\"position\":\"TE\"}]},[],[]],{\"selected_position\":[{\"coverage_type\":\"week\",\"week\":\"16\"},{\"position\":\"BN\"}]},[],{\"is_editable\":0}]},\"12\":{\"player\":[[{\"player_key\":\"331.p.9219\"},{\"player_id\":\"9219\"},{\"name\":{\"full\":\"Connor Barth\",\"first\":\"Connor\",\"last\":\"Barth\",\"ascii_first\":\"Connor\",\"ascii_last\":\"Barth\"}},{\"editorial_player_key\":\"nfl.p.9219\"},{\"editorial_team_key\":\"nfl.t.7\"},{\"editorial_team_full_name\":\"Denver Broncos\"},{\"editorial_team_abbr\":\"Den\"},{\"bye_weeks\":{\"week\":\"4\"}},{\"uniform_number\":\"1\"},{\"display_position\":\"K\"},{\"headshot\":{\"url\":\"http://l.yimg.com/iu/api/res/1.2/TBqVfeMrAwkdw99_yaigVg--/YXBwaWQ9c2hhcmVkO2NoPTIzMzY7Y3I9MTtjdz0xNzkwO2R4PTg1NztkeT0wO2ZpPXVsY3JvcDtoPTYwO3E9MTAwO3c9NDY-/https://s.yimg.com/xe/i/us/sp/v/nfl_cutout/players_l/20140830/9219.png\",\"size\":\"small\"},\"image_url\":\"http://l.yimg.com/iu/api/res/1.2/TBqVfeMrAwkdw99_yaigVg--/YXBwaWQ9c2hhcmVkO2NoPTIzMzY7Y3I9MTtjdz0xNzkwO2R4PTg1NztkeT0wO2ZpPXVsY3JvcDtoPTYwO3E9MTAwO3c9NDY-/https://s.yimg.com/xe/i/us/sp/v/nfl_cutout/players_l/20140830/9219.png\"},{\"is_undroppable\":\"0\"},{\"position_type\":\"K\"},{\"eligible_positions\":[{\"position\":\"K\"}]},[],[]],{\"selected_position\":[{\"coverage_type\":\"week\",\"week\":\"16\"},{\"position\":\"K\"}]},[],{\"is_editable\":0}]},\"13\":{\"player\":[[{\"player_key\":\"331.p.100008\"},{\"player_id\":\"100008\"},{\"name\":{\"full\":\"Detroit\",\"first\":\"Detroit\",\"last\":\"\",\"ascii_first\":\"Detroit\",\"ascii_last\":\"\"}},{\"editorial_player_key\":\"nfl.p.100008\"},{\"editorial_team_key\":\"nfl.t.8\"},{\"editorial_team_full_name\":\"Detroit Lions\"},{\"editorial_team_abbr\":\"Det\"},{\"bye_weeks\":{\"week\":\"9\"}},{\"uniform_number\":false},{\"display_position\":\"DEF\"},{\"headshot\":{\"url\":\"http://l.yimg.com/iu/api/res/1.2/Qf7aJFBfilWVG4rcwV.vjg--/YXBwaWQ9c2hhcmVkO2NoPTIwMDtjcj0xO2N3PTE1MztkeD03NDtkeT0wO2ZpPXVsY3JvcDtoPTYwO3E9MTAwO3c9NDY-/https://s.yimg.com/dh/ap/default/140828/silhouette@2x.png\",\"size\":\"small\"},\"image_url\":\"http://l.yimg.com/iu/api/res/1.2/Qf7aJFBfilWVG4rcwV.vjg--/YXBwaWQ9c2hhcmVkO2NoPTIwMDtjcj0xO2N3PTE1MztkeD03NDtkeT0wO2ZpPXVsY3JvcDtoPTYwO3E9MTAwO3c9NDY-/https://s.yimg.com/dh/ap/default/140828/silhouette@2x.png\"},{\"is_undroppable\":\"0\"},{\"position_type\":\"DT\"},{\"eligible_positions\":[{\"position\":\"DEF\"}]},[],[]],{\"selected_position\":[{\"coverage_type\":\"week\",\"week\":\"16\"},{\"position\":\"DEF\"}]},[],{\"is_editable\":0}]},\"14\":{\"player\":[[{\"player_key\":\"331.p.100034\"},{\"player_id\":\"100034\"},{\"name\":{\"full\":\"Houston\",\"first\":\"Houston\",\"last\":\"\",\"ascii_first\":\"Houston\",\"ascii_last\":\"\"}},{\"editorial_player_key\":\"nfl.p.100034\"},{\"editorial_team_key\":\"nfl.t.34\"},{\"editorial_team_full_name\":\"Houston Texans\"},{\"editorial_team_abbr\":\"Hou\"},{\"bye_weeks\":{\"week\":\"10\"}},{\"uniform_number\":false},{\"display_position\":\"DEF\"},{\"headshot\":{\"url\":\"http://l.yimg.com/iu/api/res/1.2/Qf7aJFBfilWVG4rcwV.vjg--/YXBwaWQ9c2hhcmVkO2NoPTIwMDtjcj0xO2N3PTE1MztkeD03NDtkeT0wO2ZpPXVsY3JvcDtoPTYwO3E9MTAwO3c9NDY-/https://s.yimg.com/dh/ap/default/140828/silhouette@2x.png\",\"size\":\"small\"},\"image_url\":\"http://l.yimg.com/iu/api/res/1.2/Qf7aJFBfilWVG4rcwV.vjg--/YXBwaWQ9c2hhcmVkO2NoPTIwMDtjcj0xO2N3PTE1MztkeD03NDtkeT0wO2ZpPXVsY3JvcDtoPTYwO3E9MTAwO3c9NDY-/https://s.yimg.com/dh/ap/default/140828/silhouette@2x.png\"},{\"is_undroppable\":\"0\"},{\"position_type\":\"DT\"},{\"eligible_positions\":[{\"position\":\"DEF\"}]},[],[]],{\"selected_position\":[{\"coverage_type\":\"week\",\"week\":\"16\"},{\"position\":\"BN\"}]},[],{\"is_editable\":0}]},\"count\":15}}}}],\"time\":\"155.68208694458ms\",\"copyright\":\"Data provided by Yahoo! and STATS, LLC\",\"refresh_rate\":\"31\"}}";

    public static final String SCOREBOARD_JSON = "{\"fantasy_content\":{\"xml:lang\":\"en-US\",\"yahoo:uri\":\"/fantasy/v2/league/331.l.106320/scoreboard;week=15\",\"league\":[{\"league_key\":\"331.l.106320\",\"league_id\":\"106320\",\"name\":\"Bloodlust Bowl\",\"url\":\"http://football.fantasysports.yahoo.com/archive/nfl/2014/106320\",\"password\":\"\",\"league_chat_id\":\"eugordtoqj6j5ydrziqs3bnfl90e7t8\",\"draft_status\":\"postdraft\",\"num_teams\":14,\"edit_key\":\"17\",\"weekly_deadline\":\"\",\"league_update_timestamp\":\"1420101309\",\"scoring_type\":\"head\",\"league_type\":\"private\",\"renew\":\"314_663445\",\"renewed\":\"348_155276\",\"short_invitation_url\":\"https://yho.com/nfl?l=106320&k=d6e1f2f26d736ebe\",\"is_pro_league\":\"0\",\"current_week\":\"16\",\"start_week\":\"1\",\"start_date\":\"2014-09-04\",\"end_week\":\"16\",\"end_date\":\"2014-12-22\",\"is_finished\":1,\"game_code\":\"nfl\",\"season\":\"2014\"},{\"scoreboard\":{\"week\":\"15\",\"0\":{\"matchups\":{\"0\":{\"matchup\":{\"week\":\"15\",\"week_start\":\"2014-12-09\",\"week_end\":\"2014-12-15\",\"status\":\"postevent\",\"is_playoffs\":\"1\",\"is_consolation\":\"0\",\"is_tied\":0,\"winner_team_key\":\"331.l.106320.t.1\",\"0\":{\"teams\":{\"0\":{\"team\":[[{\"team_key\":\"331.l.106320.t.1\"},{\"team_id\":\"1\"},{\"name\":\"Crusher of Dreams\"},{\"is_owned_by_current_login\":1},{\"url\":\"http://football.fantasysports.yahoo.com/archive/nfl/2014/106320/1\"},{\"team_logos\":[{\"team_logo\":{\"size\":\"large\",\"url\":\"https://i.imgur-ysports.com/BjKojTjy.jpg\"}}]},[],{\"waiver_priority\":9},[],{\"number_of_moves\":\"28\"},{\"number_of_trades\":0},{\"roster_adds\":{\"coverage_type\":\"week\",\"coverage_value\":\"17\",\"value\":\"0\"}},{\"clinched_playoffs\":1},{\"league_scoring_type\":\"head\"},{\"managers\":[{\"manager\":{\"manager_id\":\"1\",\"nickname\":\"Nathan\",\"guid\":\"TDJZVZ2P7ATEP64L37ZTW2IO7I\",\"is_commissioner\":\"1\",\"is_current_login\":\"1\",\"email\":\"detlefmagoo@yahoo.com\",\"image_url\":\"https://s.yimg.com/dh/ap/social/profile/profile_b64.png\"}}]}],{\"team_points\":{\"coverage_type\":\"week\",\"week\":\"15\",\"total\":\"82.32\"},\"team_projected_points\":{\"coverage_type\":\"week\",\"week\":\"15\",\"total\":\"92.19\"}}]},\"1\":{\"team\":[[{\"team_key\":\"331.l.106320.t.11\"},{\"team_id\":\"11\"},{\"name\":\"Chum Guzzler\"},[],{\"url\":\"http://football.fantasysports.yahoo.com/archive/nfl/2014/106320/11\"},{\"team_logos\":[{\"team_logo\":{\"size\":\"large\",\"url\":\"https://i.imgur-ysports.com/jOsOjO5y.jpg\"}}]},[],{\"waiver_priority\":12},[],{\"number_of_moves\":\"27\"},{\"number_of_trades\":0},{\"roster_adds\":{\"coverage_type\":\"week\",\"coverage_value\":\"17\",\"value\":\"0\"}},{\"clinched_playoffs\":1},{\"league_scoring_type\":\"head\"},{\"managers\":[{\"manager\":{\"manager_id\":\"11\",\"nickname\":\"lindsay\",\"guid\":\"7ZWG4QUOR7AGTWW6YUSC6GDEIE\",\"email\":\"lindsay.r.speck@gmail.com\",\"image_url\":\"https://s.yimg.com/dh/ap/social/profile/profile_b64.png\"}}]}],{\"team_points\":{\"coverage_type\":\"week\",\"week\":\"15\",\"total\":\"77.98\"},\"team_projected_points\":{\"coverage_type\":\"week\",\"week\":\"15\",\"total\":\"107.25\"}}]},\"count\":2}}}},\"1\":{\"matchup\":{\"week\":\"15\",\"week_start\":\"2014-12-09\",\"week_end\":\"2014-12-15\",\"status\":\"postevent\",\"is_playoffs\":\"1\",\"is_consolation\":\"0\",\"is_tied\":0,\"winner_team_key\":\"331.l.106320.t.4\",\"0\":{\"teams\":{\"0\":{\"team\":[[{\"team_key\":\"331.l.106320.t.4\"},{\"team_id\":\"4\"},{\"name\":\"The Beast Rider\"},[],{\"url\":\"http://football.fantasysports.yahoo.com/archive/nfl/2014/106320/4\"},{\"team_logos\":[{\"team_logo\":{\"size\":\"large\",\"url\":\"https://i.imgur-ysports.com/RQxco7Zy.jpg\"}}]},[],{\"waiver_priority\":14},[],{\"number_of_moves\":\"37\"},{\"number_of_trades\":0},{\"roster_adds\":{\"coverage_type\":\"week\",\"coverage_value\":\"17\",\"value\":\"1\"}},{\"clinched_playoffs\":1},{\"league_scoring_type\":\"head\"},{\"managers\":[{\"manager\":{\"manager_id\":\"4\",\"nickname\":\"Joe\",\"guid\":\"IQDTDHQAXDJRRRUKWBT2YMG464\",\"email\":\"jonick@gmail.com\",\"image_url\":\"https://s.yimg.com/dh/ap/social/profile/profile_b64.png\"}}]}],{\"team_points\":{\"coverage_type\":\"week\",\"week\":\"15\",\"total\":\"112.88\"},\"team_projected_points\":{\"coverage_type\":\"week\",\"week\":\"15\",\"total\":\"105.64\"}}]},\"1\":{\"team\":[[{\"team_key\":\"331.l.106320.t.12\"},{\"team_id\":\"12\"},{\"name\":\"Boss Ballerz\"},[],{\"url\":\"http://football.fantasysports.yahoo.com/archive/nfl/2014/106320/12\"},{\"team_logos\":[{\"team_logo\":{\"size\":\"large\",\"url\":\"http://l.yimg.com/dh/ap/fantasy/nfl/img/icon_01_100.png\"}}]},[],{\"waiver_priority\":3},[],{\"number_of_moves\":\"8\"},{\"number_of_trades\":0},{\"roster_adds\":{\"coverage_type\":\"week\",\"coverage_value\":\"17\",\"value\":\"0\"}},{\"clinched_playoffs\":1},{\"league_scoring_type\":\"head\"},{\"managers\":[{\"manager\":{\"manager_id\":\"12\",\"nickname\":\"Whitney\",\"guid\":\"H7N6QVPYBA6DBRLYP7ELICRWVQ\",\"email\":\"mongress@gmail.com\",\"image_url\":\"https://s.yimg.com/dh/ap/social/profile/profile_b64.png\"}}]}],{\"team_points\":{\"coverage_type\":\"week\",\"week\":\"15\",\"total\":\"97.00\"},\"team_projected_points\":{\"coverage_type\":\"week\",\"week\":\"15\",\"total\":\"89.59\"}}]},\"count\":2}}}},\"2\":{\"matchup\":{\"week\":\"15\",\"week_start\":\"2014-12-09\",\"week_end\":\"2014-12-15\",\"status\":\"postevent\",\"is_playoffs\":\"1\",\"is_consolation\":\"0\",\"is_tied\":0,\"winner_team_key\":\"331.l.106320.t.9\",\"0\":{\"teams\":{\"0\":{\"team\":[[{\"team_key\":\"331.l.106320.t.5\"},{\"team_id\":\"5\"},{\"name\":\"Scorgasmic\"},[],{\"url\":\"http://football.fantasysports.yahoo.com/archive/nfl/2014/106320/5\"},{\"team_logos\":[{\"team_logo\":{\"size\":\"large\",\"url\":\"https://i.imgur-ysports.com/kjZxcMOy.jpg\"}}]},[],{\"waiver_priority\":10},[],{\"number_of_moves\":\"26\"},{\"number_of_trades\":0},{\"roster_adds\":{\"coverage_type\":\"week\",\"coverage_value\":\"17\",\"value\":\"0\"}},{\"clinched_playoffs\":1},{\"league_scoring_type\":\"head\"},{\"managers\":[{\"manager\":{\"manager_id\":\"5\",\"nickname\":\"Whitney\",\"guid\":\"BWKLL5WAKAO7GBOHHZ2JPO2AE4\",\"email\":\"whitney.herbick@yahoo.com\",\"image_url\":\"https://s.yimg.com/dh/ap/social/profile/profile_b64.png\"}}]}],{\"team_points\":{\"coverage_type\":\"week\",\"week\":\"15\",\"total\":\"73.62\"},\"team_projected_points\":{\"coverage_type\":\"week\",\"week\":\"15\",\"total\":\"111.84\"}}]},\"1\":{\"team\":[[{\"team_key\":\"331.l.106320.t.9\"},{\"team_id\":\"9\"},{\"name\":\"Royál with Cheese\"},[],{\"url\":\"http://football.fantasysports.yahoo.com/archive/nfl/2014/106320/9\"},{\"team_logos\":[{\"team_logo\":{\"size\":\"large\",\"url\":\"https://i.imgur-ysports.com/7gfM7x2y.jpg\"}}]},[],{\"waiver_priority\":11},[],{\"number_of_moves\":\"17\"},{\"number_of_trades\":0},{\"roster_adds\":{\"coverage_type\":\"week\",\"coverage_value\":\"17\",\"value\":\"0\"}},{\"clinched_playoffs\":1},{\"league_scoring_type\":\"head\"},{\"managers\":[{\"manager\":{\"manager_id\":\"9\",\"nickname\":\"Aaron\",\"guid\":\"BGM4LFFEF6I33722EOFOWFYW4Q\",\"email\":\"amfische@yahoo.com\",\"image_url\":\"https://s.yimg.com/dh/ap/social/profile/profile_b64.png\"}}]}],{\"team_points\":{\"coverage_type\":\"week\",\"week\":\"15\",\"total\":\"105.90\"},\"team_projected_points\":{\"coverage_type\":\"week\",\"week\":\"15\",\"total\":\"98.77\"}}]},\"count\":2}}}},\"3\":{\"matchup\":{\"week\":\"15\",\"week_start\":\"2014-12-09\",\"week_end\":\"2014-12-15\",\"status\":\"postevent\",\"is_playoffs\":\"1\",\"is_consolation\":\"0\",\"is_tied\":0,\"winner_team_key\":\"331.l.106320.t.7\",\"0\":{\"teams\":{\"0\":{\"team\":[[{\"team_key\":\"331.l.106320.t.6\"},{\"team_id\":\"6\"},{\"name\":\"Nate top Joe Bottom\"},[],{\"url\":\"http://football.fantasysports.yahoo.com/archive/nfl/2014/106320/6\"},{\"team_logos\":[{\"team_logo\":{\"size\":\"large\",\"url\":\"http://l.yimg.com/dh/ap/fantasy/nfl/img/icon_11_100.png\"}}]},[],{\"waiver_priority\":13},[],{\"number_of_moves\":\"23\"},{\"number_of_trades\":0},{\"roster_adds\":{\"coverage_type\":\"week\",\"coverage_value\":\"17\",\"value\":\"0\"}},{\"clinched_playoffs\":1},{\"league_scoring_type\":\"head\"},{\"managers\":[{\"manager\":{\"manager_id\":\"6\",\"nickname\":\"Michael\",\"guid\":\"67ATOXK3E3KOO4R2Q2GYRTRZDE\",\"email\":\"sundevilmike@gmail.com\",\"image_url\":\"https://s.yimg.com/dh/ap/social/profile/profile_b64.png\"}}]}],{\"team_points\":{\"coverage_type\":\"week\",\"week\":\"15\",\"total\":\"83.00\"},\"team_projected_points\":{\"coverage_type\":\"week\",\"week\":\"15\",\"total\":\"100.49\"}}]},\"1\":{\"team\":[[{\"team_key\":\"331.l.106320.t.7\"},{\"team_id\":\"7\"},{\"name\":\"Wrecked 'em\"},[],{\"url\":\"http://football.fantasysports.yahoo.com/archive/nfl/2014/106320/7\"},{\"team_logos\":[{\"team_logo\":{\"size\":\"large\",\"url\":\"https://i.imgur-ysports.com/hrtDyxmy.jpg\"}}]},[],{\"waiver_priority\":5},[],{\"number_of_moves\":\"14\"},{\"number_of_trades\":\"1\"},{\"roster_adds\":{\"coverage_type\":\"week\",\"coverage_value\":\"17\",\"value\":\"0\"}},{\"clinched_playoffs\":1},{\"league_scoring_type\":\"head\"},{\"managers\":[{\"manager\":{\"manager_id\":\"7\",\"nickname\":\"Ian\",\"guid\":\"P5M4CH2WYAJ4MYYQPLQBIMAWYY\",\"email\":\"noitues@yahoo.com\",\"image_url\":\"https://s.yimg.com/dh/ap/social/profile/profile_b64.png\"}}]}],{\"team_points\":{\"coverage_type\":\"week\",\"week\":\"15\",\"total\":\"85.30\"},\"team_projected_points\":{\"coverage_type\":\"week\",\"week\":\"15\",\"total\":\"86.81\"}}]},\"count\":2}}}},\"count\":4}}}}],\"time\":\"140.49601554871ms\",\"copyright\":\"Data provided by Yahoo! and STATS, LLC\",\"refresh_rate\":\"31\"}}";

public static final String TEAM_JSON = "{\"team\":[[{\"team_key\":\"331.l.106320.t.1\"},{\"team_id\":\"1\"},{\"name\":\"Crusher of Dreams\"},{\"is_owned_by_current_login\":1},{\"url\":\"http://football.fantasysports.yahoo.com/archive/nfl/2014/106320/1\"},{\"team_logos\":[{\"team_logo\":{\"size\":\"large\",\"url\":\"https://i.imgur-ysports.com/BjKojTjy.jpg\"}}]},[],{\"waiver_priority\":9},[],{\"number_of_moves\":\"28\"},{\"number_of_trades\":0},{\"roster_adds\":{\"coverage_type\":\"week\",\"coverage_value\":\"17\",\"value\":\"0\"}},{\"clinched_playoffs\":1},{\"league_scoring_type\":\"head\"},{\"managers\":[{\"manager\":{\"manager_id\":\"1\",\"nickname\":\"Nathan\",\"guid\":\"TDJZVZ2P7ATEP64L37ZTW2IO7I\",\"is_commissioner\":\"1\",\"is_current_login\":\"1\",\"email\":\"detlefmagoo@yahoo.com\",\"image_url\":\"https://s.yimg.com/dh/ap/social/profile/profile_b64.png\"}}]}],{\"team_points\":{\"coverage_type\":\"week\",\"week\":\"15\",\"total\":\"82.32\"},\"team_projected_points\":{\"coverage_type\":\"week\",\"week\":\"15\",\"total\":\"92.19\"}}]}";

private Context mContext;
    private Boolean mHasAccessToken;
    private CommonsHttpOAuthProvider mProvider;
    private RetrofitHttpOAuthConsumer mConsumer;
    private SharedPreferences mPrefs;
    private Bus mBus;
    private com.ddtpt.android.fantasycompanionapp.YahooApi mService;
    private JsonDataService mJsonDataService;
    private JsonFactory mJsonFactory;
    private RestAdapter mRestAdapter;
    private JsonFactory mJsonFactory;

    String mToken, mSecret, mOAuthVerifier;


    public DataGatherUtils(Context c) {
        mContext = c;
        mHasAccessToken = false;
        mPrefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        mBus = BusProvider.getInstance();
        mBus.register(this);

        mJsonFactory = new JsonFactory();

        mToken = mPrefs.getString(TOKEN, "");
        mSecret = mPrefs.getString(SECRET, "");
        mOAuthVerifier = "";
        String sessionString = mPrefs.getString(SESSION, "");

        mConsumer = new RetrofitHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);

        mProvider = new CommonsHttpOAuthProvider(
                "https://api.login.yahoo.com/oauth/v2/get_request_token",
                "https://api.login.yahoo.com/oauth/v2/get_token",
                "https://api.login.yahoo.com/oauth/v2/request_auth"
        );

        mProvider.setOAuth10a(true);

        if (!mToken.equals("") && !mSecret.equals("")) {
            mHasAccessToken = true;
        }

        testJsonParsing();
    }

    private void testJsonParsing() {
        GsonBuilder gb = new GsonBuilder();
        gb.registerTypeAdapter(JsonFactory.Team.class, mJsonFactory.new TeamDeserializer());
        Gson gson = gb.create();

        JsonElement jsonElement = (JsonElement) new JsonParser().parse(TEAM_JSON);
        JsonArray array = jsonElement.getAsJsonObject().get("team").getAsJsonArray().get(0).getAsJsonArray();
        JsonFactory.Team team = gson.fromJson(array, JsonFactory.Team.class);
        //TODO: to set the managers/image/etc, write a method to pull the data from the original JSON and then do simple fromJson with the class.

    }

    public void getAccessToken() {
//        new ScribeRequestOAuthTokenTask().execute();
        //call Async task for OAuthRequestTokenTask.execute();
        new OAuthRequestTokenTask(mContext, mConsumer, mProvider).execute();
    }

    public void parseAccessToken(Uri uri) {
//        new ScribeGetAccessTokenTask().execute(uri);
        mOAuthVerifier = uri.getQueryParameter("oauth_verifier");
        new OAuthGetAccessTokenTask().execute();

    }

    class OAuthRequestTokenTask extends AsyncTask<Void, Void, String> {
        private Context context;
        private CommonsHttpOAuthProvider provider;
        private RetrofitHttpOAuthConsumer consumer;

        public OAuthRequestTokenTask(Context c, RetrofitHttpOAuthConsumer con, CommonsHttpOAuthProvider prov) {
            context = c;
            consumer = con;
            provider = prov;
        }

        @Override
        protected String doInBackground(Void... params) {
            try {
                Log.i(TAG, "Retrieving request token from Yahoo");
                final String authUrl = provider.retrieveRequestToken(consumer, "yffa://www.ddtpt.com");
                Log.i(TAG, "AUTHORIZATION URL: " + authUrl);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(authUrl)).setFlags(
                        Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_FROM_BACKGROUND);
                context.startActivity(intent);

                return authUrl;
            } catch (Exception e) {
                Log.e(TAG, "ERROR: " + e.toString());
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            Log.i(TAG, "onPostExecute Result: " + result);
            super.onPostExecute(result);
        }

    }

    public class OAuthGetAccessTokenTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... arg0) {
            try {
                mProvider.retrieveAccessToken(mConsumer, mOAuthVerifier);
            } catch (OAuthCommunicationException e) {
                e.printStackTrace();
            } catch (OAuthExpectationFailedException e) {
                e.printStackTrace();
            } catch (OAuthNotAuthorizedException e) {
                e.printStackTrace();
            } catch (OAuthMessageSignerException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            SharedPreferences.Editor editor = mPrefs.edit();
            editor.putString(TOKEN, mConsumer.getToken());
            editor.putString(SECRET, mConsumer.getTokenSecret());
            editor.putString(OAUTH_NONCE, mConsumer.getRequestParameters().getFirst(OAUTH_NONCE));
            editor.putString(OAUTH_SIGNATURE_METHOD, mConsumer.getRequestParameters().getFirst(OAUTH_SIGNATURE_METHOD));
            editor.putString(OAUTH_TIMESTAMP, mConsumer.getRequestParameters().getFirst(OAUTH_TIMESTAMP));

            editor.commit();
            getTokenFromPrefs();
        }
    }

    public boolean getTokenFromPrefs() {
        mToken = mPrefs.getString(TOKEN, "");
        mSecret = mPrefs.getString(SECRET, "");

        String realm = "yahooapis.com";
        final String nonce = mPrefs.getString(OAUTH_NONCE, "");
        final String sig_method = mPrefs.getString(OAUTH_SIGNATURE_METHOD, "");
        final String timestamp = mPrefs.getString(OAUTH_TIMESTAMP, "");
        final String version = "1.0";

        //new TestScribeSignature().execute();

        Log.i(TAG, "Yahoo OAuth Token: " + mToken);
        Log.i(TAG, "Yahoo OAuth Secret: " + mSecret);
        Log.i(TAG, "NONCE: " + nonce);
        Log.i(TAG, "SIGNATURE METHOD: " + sig_method);
        Log.i(TAG, "TIMESTAMP: " + timestamp);
        Log.i(TAG, "VERSION: " + version);
        Log.i(TAG, "SIGNATURE: " + mSecret);

        if (!mToken.equals("") && !mSecret.equals("") && !nonce.equals("") && !sig_method.equals("")
                && !timestamp.equals("") && !version.equals("") && !mSecret.equals("")) {
            mConsumer.setTokenWithSecret(mToken, mSecret);
            OkClient client = new SigningOkClient(mConsumer);

            mHasAccessToken = true;

            mRestAdapter = new RestAdapter.Builder()
                    .setEndpoint(BASE_URL)
                    .setClient(client)
                    .build();

            mService = mRestAdapter.create(YahooApi.class);

            return true;
        } else return false;
    }

    public void testApi() {
        mService.getPlayerData(new Callback<JsonElement>() {
            @Override
            public void success(JsonElement jsonElement, Response response) {
                //jsonElement.get("fantasy_content").getAsJsonObject().get("team").getAsJsonArray().get(0).getAsJsonArray().get(0).getAsJsonObject()
                Gson gson = new GsonBuilder().create();
                JsonArray json = jsonElement.getAsJsonObject().get("fantasy_content").getAsJsonObject().get("team").getAsJsonArray().get(0).getAsJsonArray();
                JsonFactory.Team content = gson.fromJson(json, JsonFactory.Team.class);
                //Type collectionType = new TypeToken<Collection<JsonFactory.Team>>(){}.getType();
                //Collection<JsonFactory.Team> teams = gson.fromJson(json, collectionType);

                //Use the following to setup the team data for a given owner
                JsonArray jsonArray = jsonElement.getAsJsonObject().get("fantasy_content").getAsJsonObject()
                        .get("team").getAsJsonArray().get(0).getAsJsonArray();

                Log.i(TAG, "THINGS WORKED!");

            }

            @Override
            public void failure(RetrofitError error) {
                Log.i(TAG, "THINGS DIDNT WORK");
                //analyzeFailure(error);
            }
        });
    }

    private void analyzeFailure(RetrofitError error) {
        if (error.getResponse().getHeaders().get(2).getValue().contains("token_expired")) {
            new OAuthGetAccessTokenTask().execute();
        }
    }

    public void populateLeagueData(String game_id, String league_id) {
        mService.getLeagueSettings(game_id, league_id, new Callback<JsonElement>() {
            @Override
            public void success(JsonElement jsonElement, Response response) {
                JsonFactory.League newLeague = mJsonFactory.new League();
                Gson gson = new GsonBuilder().create();
                newLeague = gson.fromJson(jsonElement, JsonFactory.base.class).getFantasyContent().getLeague().get(0);
                //TODO: Bus this shit back to the Fragment
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }


}
