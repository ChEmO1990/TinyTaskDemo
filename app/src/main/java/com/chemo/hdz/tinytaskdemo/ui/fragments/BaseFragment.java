package com.chemo.hdz.tinytaskdemo.ui.fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;

import com.chemo.hdz.tinytaskdemo.bus.BusProvider;

import butterknife.ButterKnife;

/**
 * Created by chemo1990 on 28/04/17.
 */

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Vlad on 11/17/15.
 */
public class BaseFragment extends DialogFragment {

    @CallSuper
    @Override public void onViewCreated(View view, Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
    }
}