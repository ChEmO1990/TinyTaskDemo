package com.chemo.hdz.tinytaskdemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chemo.hdz.tinytaskdemo.R;
import com.chemo.hdz.tinytaskdemo.bus.BusProvider;
import com.chemo.hdz.tinytaskdemo.rest.events.GetItemServiceEvent;
import com.chemo.hdz.tinytaskdemo.rest.events.SendItemServiceEvent;
import com.chemo.hdz.tinytaskdemo.rest.responses.ItemResponse;
import com.squareup.otto.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends BaseActivity {
    @BindView(R.id.btnPush)
    Button btnPush;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @OnClick(R.id.btnPush) void submit() {
        BusProvider.getInstance().post(new GetItemServiceEvent("Fruit", "Peaches"));
    }

    @Subscribe
    public void onSendWeatherEvent(SendItemServiceEvent sendItemServiceEvent) {
        List<ItemResponse> socratas = sendItemServiceEvent.getSocratas();
        Toast.makeText(LoginActivity.this, "Hola " + socratas.size() , Toast.LENGTH_LONG).show();
    }
}
