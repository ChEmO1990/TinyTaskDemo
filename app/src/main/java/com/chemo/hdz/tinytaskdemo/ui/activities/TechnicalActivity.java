package com.chemo.hdz.tinytaskdemo.ui.activities;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.activeandroid.query.Select;
import com.activeandroid.query.Update;
import com.chemo.hdz.tinytaskdemo.R;
import com.chemo.hdz.tinytaskdemo.adapters.AssignTaskAdapter;
import com.chemo.hdz.tinytaskdemo.adapters.TaskAdapter;
import com.chemo.hdz.tinytaskdemo.adapters.WebServiceAdapter;
import com.chemo.hdz.tinytaskdemo.bus.events.FinishTaskEvent;
import com.chemo.hdz.tinytaskdemo.entities.Hability;
import com.chemo.hdz.tinytaskdemo.entities.Task;
import com.chemo.hdz.tinytaskdemo.entities.User;
import com.chemo.hdz.tinytaskdemo.rest.responses.ItemResponse;
import com.chemo.hdz.tinytaskdemo.session.SessionManager;
import com.chemo.hdz.tinytaskdemo.ui.DividerItemDecoration;
import com.chemo.hdz.tinytaskdemo.ui.activities.BaseActivity;
import com.chemo.hdz.tinytaskdemo.util.Constants;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class TechnicalActivity extends BaseActivity {
    @BindView(R.id.toolbar_actionbar)
    Toolbar toolbar;

    @BindView(R.id.recyclerTechinical)
    RecyclerView recycler;

    private List<Task> itemsList = new ArrayList<>();
    private AssignTaskAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technical);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString("name");
            Toast.makeText(this, getString(R.string.welcome) + " " + name, Toast.LENGTH_LONG).show();
        }

        toolbar = getToolbar();
        toolbar.setTitle(R.string.title_activity_technical);

        itemsList = getAssignTasks();

        mAdapter = new AssignTaskAdapter(this, itemsList);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        recycler.setHasFixedSize(true);
        recycler.setItemViewCacheSize(20);
        recycler.setDrawingCacheEnabled(true);
        recycler.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        recycler.setAdapter(mAdapter);
    }

    private List<Task> getAssignTasks() {
        return new Select()
                .from(Task.class)
                .where("id_user = ?", SessionManager.getUserSession().getIdUser())
                .orderBy("Time ASC")
                .execute();
    }

    @Subscribe
    public void onFinishTask(FinishTaskEvent finishTaskEvent) {
        itemsList = getAssignTasks();
        mAdapter.notifyDataSetChanged();
    }
}
