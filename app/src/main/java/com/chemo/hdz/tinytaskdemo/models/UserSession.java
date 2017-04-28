package com.chemo.hdz.tinytaskdemo.models;

/**
 * Created by chemo1990 on 27/04/17.
 */

public class UserSession {
    private int idUser;
    private String user;
    private String password;
    private String userType;
    private String habilityType;

    public UserSession() {
        super();
    }

    public UserSession(int idUser, String user, String password, String userType, String habilityType) {
        this.idUser = idUser;
        this.user = user;
        this.password = password;
        this.userType = userType;
        this.habilityType = habilityType;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getHabilityType() {
        return habilityType;
    }

    public void setHabilityType(String habilityType) {
        this.habilityType = habilityType;
    }
}
