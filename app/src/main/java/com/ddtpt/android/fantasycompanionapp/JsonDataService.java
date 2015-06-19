package com.ddtpt.android.fantasycompanionapp;

/**
 * Created by e228596 on 6/17/2015.
 * This is the return type for Otto Bus to use when completing a REST request for data
 */
public class JsonDataService {
    private String jsonData;

    public JsonDataService(String json) {
        jsonData = json;
    }

}
