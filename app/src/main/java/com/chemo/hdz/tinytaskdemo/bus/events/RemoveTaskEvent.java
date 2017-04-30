package com.chemo.hdz.tinytaskdemo.bus.events;

import com.chemo.hdz.tinytaskdemo.entities.Task;

/**
 * Created by chemo1990 on 29/04/17.
 */

public class RemoveTaskEvent {
    private int position;

    public RemoveTaskEvent() {
        super();
    }
    public RemoveTaskEvent(int position) {
        super();
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
