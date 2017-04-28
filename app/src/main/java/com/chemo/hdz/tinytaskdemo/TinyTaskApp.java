package com.chemo.hdz.tinytaskdemo;

import android.app.Application;
import android.content.ContextWrapper;
import android.util.Log;

import com.activeandroid.ActiveAndroid;
import com.chemo.hdz.tinytaskdemo.bus.BusProvider;
import com.chemo.hdz.tinytaskdemo.entities.Hability;
import com.chemo.hdz.tinytaskdemo.entities.User;
import com.chemo.hdz.tinytaskdemo.models.DataDummy;
import com.chemo.hdz.tinytaskdemo.rest.RestManager;
import com.chemo.hdz.tinytaskdemo.session.SessionManager;
import com.chemo.hdz.tinytaskdemo.util.Constants;
import com.pixplicity.easyprefs.library.Prefs;
import com.squareup.otto.Bus;

import java.util.ArrayList;
import java.util.Iterator;

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

        //Init app prefs
        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();

        //Init dummy data
        if( Prefs.getBoolean(Constants.FLAG_DATA_DUMMY, true) ) {
            ArrayList<Hability> habilities_list = DataDummy.getDummyHabilities();
            ArrayList<User> users_list = DataDummy.getDummyUsers();

            Iterator<Hability> habilitiesIt = habilities_list.iterator();
            Iterator<User> usersIt = users_list.iterator();

            //Habilities Iterate
            while(habilitiesIt.hasNext()) {
                habilitiesIt.next().save();
            }

            //Users Iterate
            while(usersIt.hasNext()) {
                usersIt.next().save();
            }

            Prefs.putBoolean(Constants.FLAG_DATA_DUMMY, false); //Set flag in false - Insert only one time
        }
    }
}
