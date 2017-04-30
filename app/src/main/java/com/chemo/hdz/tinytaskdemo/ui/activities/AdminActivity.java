package com.chemo.hdz.tinytaskdemo.ui.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.activeandroid.query.Select;
import com.chemo.hdz.tinytaskdemo.R;
import com.chemo.hdz.tinytaskdemo.bus.events.RemoveTaskEvent;
import com.chemo.hdz.tinytaskdemo.adapters.TaskAdapter;
import com.chemo.hdz.tinytaskdemo.bus.events.AddTaskEvent;
import com.chemo.hdz.tinytaskdemo.entities.Task;
import com.chemo.hdz.tinytaskdemo.ui.DividerItemDecoration;
import com.chemo.hdz.tinytaskdemo.ui.fragments.AddTaskDialogFragment;
import com.squareup.otto.Subscribe;

import java.util.List;
import butterknife.BindView;

public class AdminActivity extends BaseActivity {
    @BindView(R.id.toolbar_actionbar)
    Toolbar toolbar;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.recyclerTasks)
    RecyclerView recycler;

    private List<Task> itemsList;
    private TaskAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString("name");
            Toast.makeText(this, getString(R.string.welcome) + " " + name, Toast.LENGTH_LONG).show();
        }

        toolbar = getToolbar();
        toolbar.setTitle(R.string.title_activity_admin);

        itemsList = getTasks();

        mAdapter = new TaskAdapter(this, itemsList);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        recycler.setHasFixedSize(true);
        recycler.setItemViewCacheSize(20);
        recycler.setDrawingCacheEnabled(true);
        recycler.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        recycler.setAdapter(mAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AddTaskDialogFragment().show(getSupportFragmentManager(), "add_task_dialog");
            }
        });
    }

    @Subscribe
    public void onAddTaskListener(AddTaskEvent addTaskEvent) {
        Toast.makeText(this, getString(R.string.message_assign_work), Toast.LENGTH_SHORT).show();
        itemsList.add(addTaskEvent.getTask());
        mAdapter.notifyDataSetChanged();
    }

    @Subscribe
    public void onRemoveTaskListener(RemoveTaskEvent removeTaskEvent) {
        itemsList.remove(removeTaskEvent.getPosition());
        mAdapter.notifyDataSetChanged();
    }

    private List<Task> getTasks() {
        return new Select()
                .from(Task.class)
                .orderBy("Time ASC")
                .execute();
    }
}
