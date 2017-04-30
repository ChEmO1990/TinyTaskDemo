package com.chemo.hdz.tinytaskdemo.ui.activities;


import android.content.ClipData;
import android.os.Bundle;
import android.support.constraint.solver.SolverVariable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.chemo.hdz.tinytaskdemo.R;
import com.chemo.hdz.tinytaskdemo.adapters.WebServiceAdapter;
import com.chemo.hdz.tinytaskdemo.bus.BusProvider;
import com.chemo.hdz.tinytaskdemo.rest.events.GetItemServiceEvent;
import com.chemo.hdz.tinytaskdemo.rest.events.SendItemServiceEvent;
import com.chemo.hdz.tinytaskdemo.rest.events.WebServiceErrorEvent;
import com.chemo.hdz.tinytaskdemo.rest.responses.ItemResponse;
import com.chemo.hdz.tinytaskdemo.ui.DividerItemDecoration;
import com.chemo.hdz.tinytaskdemo.ui.activities.BaseActivity;
import com.chemo.hdz.tinytaskdemo.util.Constants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pixplicity.easyprefs.library.Prefs;
import com.squareup.otto.Subscribe;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class WebServiceActivity extends BaseActivity {
    @BindView(R.id.toolbar_actionbar)
    Toolbar toolbar;

    @BindView(R.id.recyclerWebservice)
    RecyclerView recycler;

    private List<ItemResponse> itemsList = new ArrayList<>();
    private WebServiceAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service);

        toolbar = getToolbar();
        toolbar.setTitle(R.string.title_activity_webservice);
        toolbar.setNavigationIcon(R.mipmap.ic_up);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mAdapter = new WebServiceAdapter(this, itemsList);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        recycler.setHasFixedSize(true);
        recycler.setItemViewCacheSize(20);
        recycler.setDrawingCacheEnabled(true);
        recycler.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        recycler.setAdapter(mAdapter);

        BusProvider.getInstance().post(new GetItemServiceEvent("Fruit", "Peaches"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_webservice, menu);
        return true;
    }

    @Subscribe
    public void onOkWebServiceResponse(SendItemServiceEvent sendItemServiceEvent) {
        List<ItemResponse> items = sendItemServiceEvent.getSocratas();

        //Save the json data
        String json = new Gson().toJson(items);
        Prefs.putString(Constants.JSON_DATA, json);

        itemsList.addAll(items);
        mAdapter.notifyDataSetChanged();
    }

    @Subscribe
    public void onErrorWebServiceResponse(WebServiceErrorEvent webServiceErrorEvent) {
        if (!TextUtils.isEmpty(Prefs.getString(Constants.JSON_DATA, null))) {

            String json = Prefs.getString(Constants.JSON_DATA, null);

            Type type = new TypeToken<List<ItemResponse >>() {}.getType();
            List < ItemResponse > items = new Gson().fromJson(json, type);

            itemsList.addAll(items);
            mAdapter.notifyDataSetChanged();

            new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText(getString(R.string.title_data_recovery))
                    .setContentText(getString(R.string.message_data_recovery))
                    .show();
        } else {
            new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText(getString(R.string.title_error))
                    .setContentText(getString(R.string.message_data_error))
                    .show();
        }
    }
}
