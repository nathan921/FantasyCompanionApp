package com.ddtpt.android.fantasycompanionapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.util.Log;

import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.net.MulticastSocket;

import oauth.signpost.OAuth;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.basic.DefaultOAuthProvider;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;

/**
 * Created by e228596 on 6/17/2015.
 */
public class DataGatherUtils {
    private static final String TAG = "DataGatherUtils";

    private static final String SECRET = "oauth_secret";
    private static final String TOKEN = "oauth_token";
    private static final String SESSION = "oauth_session_handle";

    private static final String BASE_URL = "http://fantasysports.yahooapis.com/fantasy/v2/";
    private static final String GET_TOKEN = "https://api.login.yahoo.com/oauth/v2/get_token";


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

    private Context mContext;
    private Boolean mHasAccessToken;
    private OAuthProvider mProvider;
    private OAuthConsumer mConsumer;
    private SharedPreferences mPrefs;
    private Bus mBus;
    private YahooApi mService;
    private RestAdapter mRestAdapter;
    String mToken, mSecret;

    public DataGatherUtils(Context c) {
        mContext = c;
        mHasAccessToken = false;
        mPrefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        mBus = BusProvider.getInstance();
        mBus.register(this);
        String sessionString;
        
        mToken = mPrefs.getString(TOKEN, "");
        mSecret = mPrefs.getString(SECRET, "");
        sessionString = mPrefs.getString(SESSION, "");

        mConsumer = new DefaultOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);

        mProvider = new DefaultOAuthProvider(
                "https://api.login.yahoo.com/oauth/v2/get_request_token",
                "https://api.login.yahoo.com/oauth/v2/request_auth",
                "https://api.login.yahoo.com/oauth/v2/get_token"
        );
        mProvider.setOAuth10a(true);

        if (!mToken.equals("") && !mSecret.equals("") && !sessionString.equals("")) {
            mHasAccessToken = true;
        }
    }

    public void getAccessToken() {
        String authUrl;
        try {
            authUrl = mProvider.retrieveRequestToken(mConsumer, OAuth.OUT_OF_BAND);
            Log.i(TAG, "Yahoo URL: " + authUrl);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(authUrl)).setFlags(
                    Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_FROM_BACKGROUND);
            mContext.startActivity(intent);
        } catch(Exception e) {
            Log.e(TAG, e.toString());
        }
    }

    public void parseAccessToken(Uri uri) {
        final String oauth_verifier = uri.getQueryParameter(OAuth.OAUTH_VERIFIER);
        try {
            mProvider.retrieveAccessToken(mConsumer, oauth_verifier);

            final SharedPreferences.Editor edit = mPrefs.edit();
            edit.putString(TOKEN, mConsumer.getToken());
            edit.putString(SECRET, mConsumer.getTokenSecret());
            edit.commit();

            getTokenFromPrefs();
        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
    }
    public boolean getTokenFromPrefs() {

        mToken = mPrefs.getString(TOKEN, "");
        mSecret = mPrefs.getString(SECRET, "");

        Log.i(TAG, "Yahoo OAuth Token: " + mToken);
        Log.i(TAG, "Yahoo OAuth Secret: " + mSecret);

        if (!mToken.equals("") && !mSecret.equals("")) {
            mConsumer.setTokenWithSecret(mToken, mSecret);
            mHasAccessToken = true;
            generateApiService();
            return true;
        } else return false;
    }

    public void generateApiService() {
        mRestAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        if (mHasAccessToken) {
                            request.addHeader("Authorization", mToken);
                        }
                    }
                })
                .build();
        mService = mRestAdapter.create(YahooApi.class);
    }



}
