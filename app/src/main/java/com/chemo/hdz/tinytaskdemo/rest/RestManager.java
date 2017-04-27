package com.chemo.hdz.tinytaskdemo.rest;

import android.content.Context;
import android.util.Log;
import com.chemo.hdz.tinytaskdemo.bus.BusProvider;
import com.chemo.hdz.tinytaskdemo.rest.events.GetItemServiceEvent;
import com.chemo.hdz.tinytaskdemo.rest.events.SendItemServiceEvent;
import com.chemo.hdz.tinytaskdemo.rest.responses.ItemResponse;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by chemo on 4/3/17.
 */

public class RestManager {
    private Context mContext;
    private Bus mBus;
    private RestClient sRestClient;

    public RestManager(Context context, Bus bus) {
        this.mContext = context;
        this.mBus = bus;
        sRestClient = RestClient.getClient();
    }

    @Subscribe
    public void onGetService( GetItemServiceEvent getItemServiceEvent ) {
        Callback<List<ItemResponse>>  serviceCallback = new Callback<List<ItemResponse>>() {
            @Override
            public void success(List<ItemResponse> socratas, Response response) {
                BusProvider.getInstance().post(new SendItemServiceEvent(socratas));
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("Error", error.getResponse().getReason());
                error.printStackTrace();
            }
        };

        sRestClient.getService( getItemServiceEvent.getCategory(), getItemServiceEvent.getItem(), serviceCallback);
    }
}
