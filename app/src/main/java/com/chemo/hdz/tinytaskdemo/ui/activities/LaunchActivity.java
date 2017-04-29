package com.chemo.hdz.tinytaskdemo.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.chemo.hdz.tinytaskdemo.session.SessionManager;

/**
 * Created by chemo1990 on 28/04/17.
 */

public class LaunchActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(SessionManager.isActiveSession() ) {
            String userType = SessionManager.getUserSession().getUserType();
            //R = ROOT - T = Technical

            if( userType.equals("R") ) {
                redirectTo(AdminActivity.class);
            } else {
                redirectTo(TechnicalActivity.class);
            }
        } else {
            redirectTo(LoginActivity.class);
        }
    }

    private void redirectTo(Class<?> ActivityClass) {
        Intent intent = new Intent(this, ActivityClass);
        startActivity(intent);
        finish();
    }
}
