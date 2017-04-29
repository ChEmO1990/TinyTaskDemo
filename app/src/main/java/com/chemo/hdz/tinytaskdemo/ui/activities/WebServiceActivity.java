package com.chemo.hdz.tinytaskdemo.ui.activities;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.chemo.hdz.tinytaskdemo.R;
import com.chemo.hdz.tinytaskdemo.adapters.WebServiceAdapter;
import com.chemo.hdz.tinytaskdemo.bus.BusProvider;
import com.chemo.hdz.tinytaskdemo.rest.events.GetItemServiceEvent;
import com.chemo.hdz.tinytaskdemo.rest.events.SendItemServiceEvent;
import com.chemo.hdz.tinytaskdemo.rest.responses.ItemResponse;
import com.chemo.hdz.tinytaskdemo.ui.DividerItemDecoration;
import com.chemo.hdz.tinytaskdemo.ui.activities.BaseActivity;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

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

        BusProvider.getInstance().post( new GetItemServiceEvent("Fruit", "Peaches"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_webservice, menu);
        return true;
    }

    @Subscribe
    public void onSendWeatherEvent(SendItemServiceEvent sendItemServiceEvent) {
        List<ItemResponse> items = sendItemServiceEvent.getSocratas();
        itemsList.addAll(items);
        mAdapter.notifyDataSetChanged();
    }
}
