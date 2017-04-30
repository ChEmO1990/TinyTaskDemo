package com.chemo.hdz.tinytaskdemo.logic;

import android.util.Log;

import com.activeandroid.query.Select;
import com.activeandroid.query.Update;
import com.chemo.hdz.tinytaskdemo.bus.BusProvider;
import com.chemo.hdz.tinytaskdemo.bus.events.AddTaskEvent;
import com.chemo.hdz.tinytaskdemo.entities.Hability;
import com.chemo.hdz.tinytaskdemo.entities.Task;
import com.chemo.hdz.tinytaskdemo.entities.User;
import com.chemo.hdz.tinytaskdemo.util.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import static android.R.id.list;

/**
 * Created by chemo1990 on 29/04/17.
 */

public final class TaskManager {
    private int idHability;
    private String description;
    private int duration;

    public TaskManager(int idHability, String description, int duration) {
        this.idHability = idHability;
        this.description = description;
        this.duration = duration;
    }

    public TaskManager assignTask() {
        List<User> items = getUsers();
        List<User> copyItems =  new ArrayList<User>();
        List<Integer> hours =  new ArrayList<Integer>();
        String arrayMultipleHability[] = null;

        for( int i = 0; i < items.size(); i++ ) {
            if (items.get(i).habilityType.equals(String.valueOf(idHability))) {
                copyItems.add(items.get(i));
                hours.add(items.get(i).timeWork);
            } else {
                arrayMultipleHability = singleChars(items.get(i).habilityType);
                if (arrayMultipleHability.length > 1) {
                    for (int j = 0; j < arrayMultipleHability.length; j++) {
                        if (arrayMultipleHability[j].equals(String.valueOf(idHability))) {
                            copyItems.add(items.get(i));
                            hours.add(items.get(i).timeWork);
                        }
                    }
                }
            }
        }

        //This is the selected user
        User userSelected = Collections.max(copyItems, new compPopulation());

        //Get current time work
        User currentUser = new Select()
                .from(User.class)
                .where("id_user = ?", userSelected.idUser)
                .executeSingle();

        int currentTimeWork = currentUser.timeWork;
        int totalTimeUpdate = currentTimeWork += duration;
        Log.i("CHEMOO", "Tiempo actual: " + currentTimeWork + " minutos");
        Log.i("CHEMOO", "Nuevo tiempo: " + totalTimeUpdate + " minutos");

        new Update(User.class)
                .set("Time_work = " + totalTimeUpdate)
                .where("Id_user = ?", userSelected.idUser)
                .execute();

        for( int i = 0; i < copyItems.size(); i++ ) {
            Log.i("CHEMOO", copyItems.get(i).idUser + " - "  + copyItems.get(i).userName);
        }

        Log.i("CHEMOO", userSelected.toString());

        Task newTask = new Task();
        newTask.idUser = userSelected.idUser;
        newTask.idHability = idHability;
        newTask.description = description;
        newTask.currentStatus = 1;
        newTask.time = duration;
        newTask.save();

        BusProvider.getInstance().post(new AddTaskEvent(newTask));

        return this;
    }

    private List<User> getUsers() {
        return new Select().from(User.class).execute();
    }

    public static String[] singleChars(String s) {
        return s.split(",");
    }

    public class compPopulation implements Comparator<User> {
        public int compare(User a, User b) {
            if (a.timeWork > b.timeWork)
                return -1; // highest value first
            if (a.timeWork == b.timeWork)
                return 0;
            return 1;
        }
    }
}
