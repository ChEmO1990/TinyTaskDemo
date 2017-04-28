package com.chemo.hdz.tinytaskdemo.session;

import com.chemo.hdz.tinytaskdemo.models.UserSession;
import com.chemo.hdz.tinytaskdemo.util.Constants;
import com.pixplicity.easyprefs.library.Prefs;

/**
 * Created by chemo1990 on 27/04/17.
 */

public class SessionManager {

    public static UserSession getUserSession() {
        UserSession session = new UserSession();
        session.setIdUser(Prefs.getInt(Constants.ID_USER, -1));
        session.setUser(Prefs.getString(Constants.USER, null));
        session.setPassword(Prefs.getString(Constants.PASSWORD, null));
        session.setUserType(Prefs.getString(Constants.USER_TYPE, null));
        session.setHabilityType(Prefs.getString(Constants.HABILITY_TYPE, null));
        return session;
    }

    public static void createUserSession(UserSession session) {
        Prefs.putInt(Constants.ID_USER, session.getIdUser());
        Prefs.putString(Constants.USER, session.getUser());
        Prefs.putString(Constants.PASSWORD, session.getPassword());
        Prefs.putString(Constants.USER_TYPE, session.getUserType());
        Prefs.putString(Constants.HABILITY_TYPE, session.getHabilityType());
    }

    public static void clearUserSession() {
        Prefs.remove(Constants.ID_USER);
        Prefs.remove(Constants.USER);
        Prefs.remove(Constants.PASSWORD);
        Prefs.remove(Constants.USER_TYPE);
        Prefs.remove(Constants.HABILITY_TYPE);
    }

    public static boolean isActiveSession() {
        boolean status = false;
        UserSession currentSession = getUserSession();
        if( currentSession.getIdUser() != -1 ) {
            status = true;
        }
        return status;
    }
}
