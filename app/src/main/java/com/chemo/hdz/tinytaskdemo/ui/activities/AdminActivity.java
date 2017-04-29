package com.chemo.hdz.tinytaskdemo.ui.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.chemo.hdz.tinytaskdemo.R;

import butterknife.BindView;

public class AdminActivity extends BaseActivity {
    @BindView(R.id.toolbar_actionbar)
    Toolbar toolbar;

    @BindView(R.id.fab)
    FloatingActionButton fab;

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

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
