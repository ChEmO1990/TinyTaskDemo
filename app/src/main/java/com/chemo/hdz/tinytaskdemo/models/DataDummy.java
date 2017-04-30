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

        User admin = new User();
        admin.idUser = 1;
        admin.userName = "anselmo";
        admin.password = "chemo1990";
        admin.name = "Anselmo Hernandez";
        admin.userType = "R";
        admin.habilityType = "1";
        admin.timeWork = 0;

        User user1 = new User();
        user1.idUser = 143;
        user1.userName = "salvador";
        user1.password = "chava30";
        user1.name = "Salvador Rodriguez";
        user1.userType = "T";
        user1.habilityType = "2";
        user1.timeWork = 0;

        User user2 = new User();
        user2.idUser = 33;
        user2.userName = "mike";
        user2.password = "elmike";
        user2.name = "Miguel Fuentes";
        user2.userType = "T";
        user2.habilityType = "3";
        user2.timeWork = 0;

        User user3 = new User();
        user3.idUser = 424;
        user3.userName = "beto90";
        user3.password = "betito";
        user3.name = "Alberto Castro";
        user3.userType = "T";
        user3.habilityType = "4";
        user3.timeWork = 0;

        User user4 = new User();
        user4.idUser = 938;
        user4.userName = "david89";
        user4.password = "eldavid";
        user4.name = "David Chavez";
        user4.userType = "T";
        user4.habilityType = "5";
        user4.timeWork = 0;

        User user5 = new User();
        user5.idUser = 43;
        user5.userName = "yazmin";
        user5.password = "yaz90";
        user5.name = "Yazmin Coronado";
        user5.userType = "T";
        user5.habilityType = "6";
        user5.timeWork = 0;

        User user6 = new User();
        user6.idUser = 311;
        user6.userName = "omar";
        user6.password = "omarcito";
        user6.name = "Omar Fuentes";
        user6.userType = "T";
        user6.habilityType = "3,4";
        user6.timeWork = 0;

        User user7 = new User();
        user7.idUser = 841;
        user7.userName = "liz";
        user7.password = "lizz";
        user7.name = "Lizbeth Palacios";
        user7.userType = "T";
        user7.habilityType = "4,6";
        user7.timeWork = 0;

        User user8 = new User();
        user8.idUser = 999;
        user8.userName = "fatima";
        user8.password = "faty";
        user8.name = "Fatima Arenas";
        user8.userType = "T";
        user8.habilityType = "2,5,6";
        user8.timeWork = 0;

        users.add(admin);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        users.add(user8);
        return users;
    }
}
