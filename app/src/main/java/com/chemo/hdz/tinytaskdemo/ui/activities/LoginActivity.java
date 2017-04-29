package com.chemo.hdz.tinytaskdemo.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.activeandroid.query.Select;
import com.chemo.hdz.tinytaskdemo.R;
import com.chemo.hdz.tinytaskdemo.entities.User;
import com.chemo.hdz.tinytaskdemo.models.UserSession;
import com.chemo.hdz.tinytaskdemo.rest.events.SendItemServiceEvent;
import com.chemo.hdz.tinytaskdemo.rest.responses.ItemResponse;
import com.chemo.hdz.tinytaskdemo.session.SessionManager;
import com.squareup.otto.Subscribe;
import com.vstechlab.easyfonts.EasyFonts;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.titleLogin)
    TextView titleLogin;

    @BindView(R.id.editUser)
    EditText editUser;

    @BindView(R.id.editPassword)
    EditText editPassword;

    @BindView(R.id.btnLogin)
    Button btnLogin;

    @BindView(R.id.btnCancel)
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Set font
        titleLogin.setTypeface(EasyFonts.droidSerifBold(this));
    }

    @OnClick(R.id.btnLogin) void login() {
        if( TextUtils.isEmpty( editUser.getText().toString()) && TextUtils.isEmpty( editPassword.getText().toString() ) ) {
            Toast.makeText(this, getString(R.string.text_empty_credentials), Toast.LENGTH_LONG).show();
        } else {
            User currentUser = new Select()
                    .from(User.class)
                    .where("user = ?", editUser.getText().toString())
                    .where("password = ?", editPassword.getText().toString())
                    .executeSingle();

            //User not found
            if( currentUser == null ) {
                Toast.makeText(this, getString(R.string.text_wrong_credentials), Toast.LENGTH_LONG).show();
            } else {
                //User ok, we need to check what kind of user it´s and save session
                UserSession session = new UserSession();
                session.setIdUser(currentUser.idUser);
                session.setUser(currentUser.userName);
                session.setPassword(currentUser.password);
                session.setUserType(currentUser.userType);
                session.setHabilityType(currentUser.habilityType);

                //We create the current session
                SessionManager.createUserSession(session);

                //If the current kind of user is = R (Root)
                if( currentUser.userType.equals("R") ) {
                    Intent intentRoot = new Intent(this, AdminActivity.class);
                    intentRoot.putExtra("name", currentUser.name);
                    intentRoot.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentRoot);
                } else {
                    //It's a technical user (T)
                    Intent intentTechnical = new Intent(this, TechnicalActivity.class);
                    intentTechnical.putExtra("name", currentUser.name);
                    intentTechnical.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intentTechnical);
                }
            }
        }
    }


    @OnClick(R.id.btnCancel) void cancel() {
        finish();
    }

    @Subscribe
    public void onSendWeatherEvent(SendItemServiceEvent sendItemServiceEvent) {
        List<ItemResponse> socratas = sendItemServiceEvent.getSocratas();
        Toast.makeText(LoginActivity.this, "Hola " + socratas.size() , Toast.LENGTH_LONG).show();
    }
}
