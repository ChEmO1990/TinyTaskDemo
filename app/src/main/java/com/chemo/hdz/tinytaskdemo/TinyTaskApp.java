package com.chemo.hdz.tinytaskdemo;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.chemo.hdz.tinytaskdemo.bus.BusProvider;
import com.chemo.hdz.tinytaskdemo.rest.RestManager;
import com.squareup.otto.Bus;

/**
 * Created by chemo on 4/26/17.
 */

public class TinyTaskApp extends Application {
    private RestManager mRestManager;
    private Bus mBus = BusProvider.getInstance();

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);

        mRestManager = new RestManager(this, mBus);
        mBus.register(mRestManager);
    }
}
