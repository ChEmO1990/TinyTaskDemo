package com.chemo.hdz.tinytaskdemo.ui.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.chemo.hdz.tinytaskdemo.R;
import com.chemo.hdz.tinytaskdemo.ui.activities.BaseActivity;

import butterknife.BindView;

public class TechnicalActivity extends BaseActivity {
    @BindView(R.id.toolbar_actionbar)
    Toolbar toolbar;

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
    }
}
