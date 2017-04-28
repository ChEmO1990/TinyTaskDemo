package com.chemo.hdz.tinytaskdemo.ui;


import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.chemo.hdz.tinytaskdemo.R;
import com.chemo.hdz.tinytaskdemo.adapters.WebServiceAdapter;
import com.chemo.hdz.tinytaskdemo.models.WebServiceItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class WebServiceActivity extends BaseActivity {
    @BindView(R.id.toolbar_actionbar)
    Toolbar toolbar;

    @BindView(R.id.recyclerWebservice)
    RecyclerView recycler;

    private List<WebServiceItem> itemsList = new ArrayList<>();
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
        recycler.setHasFixedSize(true);
        recycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        recycler.setAdapter(mAdapter);

        itemsList.add( new WebServiceItem("Peaches", "18th Century Purity Farms at the Hall Homestead", "860-564-8733", "http://www.dagatas.com,", "06374") );
        itemsList.add( new WebServiceItem("Peaches", "18th Century Purity Farms at the Hall Homestead", "860-564-8733", "http://www.dagatas.com,", "06374") );
        itemsList.add( new WebServiceItem("Peaches", "18th Century Purity Farms at the Hall Homestead", "860-564-8733", "http://www.dagatas.com,", "06374") );
        itemsList.add( new WebServiceItem("Peaches", "18th Century Purity Farms at the Hall Homestead", "860-564-8733", "http://www.dagatas.com,", "06374") );
        itemsList.add( new WebServiceItem("Peaches", "18th Century Purity Farms at the Hall Homestead", "860-564-8733", "http://www.dagatas.com,", "06374") );
        itemsList.add( new WebServiceItem("Peaches", "18th Century Purity Farms at the Hall Homestead", "860-564-8733", "http://www.dagatas.com,", "06374") );
        itemsList.add( new WebServiceItem("Peaches", "18th Century Purity Farms at the Hall Homestead", "860-564-8733", "http://www.dagatas.com,", "06374") );
        itemsList.add( new WebServiceItem("Peaches", "18th Century Purity Farms at the Hall Homestead", "860-564-8733", "http://www.dagatas.com,", "06374") );
        itemsList.add( new WebServiceItem("Peaches", "18th Century Purity Farms at the Hall Homestead", "860-564-8733", "http://www.dagatas.com,", "06374") );
        itemsList.add( new WebServiceItem("Peaches", "18th Century Purity Farms at the Hall Homestead", "860-564-8733", "http://www.dagatas.com,", "06374") );

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_webservice, menu);
        return true;
    }
}
