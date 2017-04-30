package com.chemo.hdz.tinytaskdemo.bus.events;

import com.chemo.hdz.tinytaskdemo.entities.Task;

/**
 * Created by chemo1990 on 29/04/17.
 */

public class FinishTaskEvent {
    private Task task;

    public FinishTaskEvent() {
        super();
    }

    public FinishTaskEvent(Task task) {
        this.task = task;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
