package com.chemo.hdz.tinytaskdemo.bus.events;

import com.chemo.hdz.tinytaskdemo.entities.Task;

/**
 * Created by chemo1990 on 29/04/17.
 */

public class AddTaskEvent {
    private Task task;

    public AddTaskEvent() {
        super();
    }

    public AddTaskEvent(Task task) {
        super();
        this.task = task;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
