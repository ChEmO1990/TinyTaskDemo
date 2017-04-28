package com.chemo.hdz.tinytaskdemo.entities;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by chemo on 4/26/17.
 */

@Table(name = "User")
public class User extends Model {
    @Column(name = "id_user")
    public int idUser;

    @Column(name = "user")
    public String userName;

    @Column(name = "password")
    public String password;

    @Column(name = "name")
    public String name;

    @Column(name = "age")
    public int age;

    @Column(name = "gender")
    public String gender;

    @Column(name = "user_type")
    public String userType;

    @Column(name = "hability_type")
    public String habilityType;

    public User() {
        super();
    }

    public User(int idUser, String userName, String password, String name, int age, String gender, String userType, String habilityType) {
        this.idUser = idUser;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.userType = userType;
        this.habilityType = habilityType;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", userType='" + userType + '\'' +
                ", habilityType='" + habilityType + '\'' +
                '}';
    }
}