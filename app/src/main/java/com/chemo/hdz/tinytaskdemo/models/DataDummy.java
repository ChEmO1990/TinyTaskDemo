package com.chemo.hdz.tinytaskdemo.models;

import com.chemo.hdz.tinytaskdemo.entities.Hability;
import com.chemo.hdz.tinytaskdemo.entities.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chemo1990 on 27/04/17.
 */

public class DataDummy {
    public static ArrayList<Hability> getDummyHabilities() {
        ArrayList<Hability> habilities = new ArrayList<>();
        habilities.add( new Hability(1, "Administrador"));
        habilities.add( new Hability(2, "Cocinar"));
        habilities.add( new Hability(3, "Barrer"));
        habilities.add( new Hability(4, "Cortar verduras"));
        habilities.add( new Hability(5, "Sacar la basura"));
        habilities.add( new Hability(6, "Trapear"));
        return habilities;
    }

    public static ArrayList<User> getDummyUsers() {
        ArrayList<User> users = new ArrayList<>();
        users.add( new User(118, "anselmo", "java3098", "Anselmo Hernandez", 27, "M", "R", "1", 0));
        users.add( new User(345, "melissa", "mely20", "Melissa Garcia", 23, "F", "T", "2", 0));
        users.add( new User(221, "luis", "luis_198", "Luis Hernandez", 26, "M", "T", "2", 0));
        users.add( new User(111, "heriberto22", "heri22", "Heriberto Contreras", 27, "M", "T", "4", 0));
        users.add( new User(980, "yazmin", "yaz_25", "Yazmin Coronado", 27, "F", "T", "3", 0));
        users.add( new User(420, "dany", "daniella", "Daniela Ruz", 30, "F", "T", "2,4", 0));
        users.add( new User(983, "omar", "omarcito", "Omar Herrera", 27, "M", "T", "6", 0));
        users.add( new User(443, "ulises", "123456", "Ulises RUiz", 27, "M", "T", "5", 0));
        users.add( new User(784, "gaby33", "gaby1990", "Gabriela Hernandez", 27, "F", "T", "5", 0));
        users.add( new User(254, "josefina", "josy25", "Josefina Martinez", 25, "F", "T", "1,4", 0));
        return users;
    }
}
