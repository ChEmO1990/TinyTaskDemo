package com.chemo.hdz.tinytaskdemo.bus;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Created by chemo on 4/27/17.
 */

public class BusProvider {
    private static volatile Bus instance;

    private BusProvider() {}

    public static Bus getInstance() {
        Bus localInstance = instance;
        if (localInstance == null) {
            synchronized (Bus.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Bus(ThreadEnforcer.ANY);
                }
            }
        }
        return localInstance;
    }
}
