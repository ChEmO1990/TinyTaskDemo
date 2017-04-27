package com.chemo.hdz.tinytaskdemo.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.chemo.hdz.tinytaskdemo.bus.BusProvider;

import butterknife.ButterKnife;


/**
 * Created by chemo on 4/27/17.
 */

public class BaseActivity extends AppCompatActivity {

    @Override public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        BusProvider.getInstance().unregister(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        BusProvider.getInstance().register(this);
    }
}
