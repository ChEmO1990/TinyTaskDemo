package com.chemo.hdz.tinytaskdemo.entities;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by chemo on 4/27/17.
 */

@Table(name = "Task", id = "_id")
public class Task extends Model {
    @Column(name = "id_user")
    public int idUser;

    @Column(name = "id_hability")
    public int idHability;

    @Column(name = "time")
    public int time;

    @Column(name = "description")
    public String description;

    @Column(name = "current_status")
    public int currentStatus;

    public Task() {
        super();
    }

    public Task(int idUser, int idHability, int time, String description, int currentStatus) {
        this.idUser = idUser;
        this.idHability = idHability;
        this.time = time;
        this.description = description;
        this.currentStatus = currentStatus;
    }

    @Override
    public String toString() {
        return "Task{" +
                "idUser=" + idUser +
                ", idHability=" + idHability +
                ", time=" + time +
                ", description='" + description + '\'' +
                ", currentStatus=" + currentStatus +
                '}';
    }
}
