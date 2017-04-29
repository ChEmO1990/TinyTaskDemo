package com.chemo.hdz.tinytaskdemo.ui.fragments;

/**
 * Created by chemo1990 on 28/04/17.
 */


import com.chemo.hdz.tinytaskdemo.bus.BusProvider;

/**
 * Created by Vlad on 11/17/15.
 */
public class BaseSubscriberFragment extends BaseFragment {

    @Override public void onStart() {
        super.onStart();
        BusProvider.getInstance().register(this);
    }

    @Override public void onStop() {
        super.onStop();
        BusProvider.getInstance().unregister(this);
    }

}