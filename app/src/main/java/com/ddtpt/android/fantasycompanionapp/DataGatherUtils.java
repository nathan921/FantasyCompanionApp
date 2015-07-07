package com.ddtpt.android.fantasycompanionapp;

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
import com.google.gson.reflect.TypeToken;
import com.squareup.otto.Bus;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

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

    private Context mContext;
    private Boolean mHasAccessToken;
    private CommonsHttpOAuthProvider mProvider;
    private RetrofitHttpOAuthConsumer mConsumer;
    private SharedPreferences mPrefs;
    private Bus mBus;
    private com.ddtpt.android.fantasycompanionapp.YahooApi mService;
    private JsonDataService mJsonDataService;
    private RestAdapter mRestAdapter;
    private Gson mGson;

    String mToken, mSecret, mOAuthVerifier;


    public DataGatherUtils(Context c) {
        mContext = c;
        mHasAccessToken = false;
        mPrefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        mBus = BusProvider.getInstance();
        mBus.register(this);

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

}
