package com.chemo.hdz.tinytaskdemo.rest;


import com.chemo.hdz.tinytaskdemo.rest.responses.ItemResponse;
import com.chemo.hdz.tinytaskdemo.rest.services.ApiService;
import com.squareup.okhttp.OkHttpClient;


import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by chemo on 4/3/17.
 */

public class RestClient {
    private static final String BASE_URL = "https://data.ct.gov/resource/hma6-9xbg.json";

    private static RestClient mClient;
    private static RestAdapter mRestAdapter;

    public static RestClient getClient() {
        if (mClient == null)
            mClient = new RestClient();
        return mClient;
    }

    private RestClient() {
        mRestAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setClient(new OkClient(new OkHttpClient()))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
    }

    public void getService(String category, String item, Callback<List<ItemResponse>> callBack) {
        ApiService service = mRestAdapter.create(ApiService.class);
        service.getItems(category, item, callBack);
    }
}
