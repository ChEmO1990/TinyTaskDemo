package com.chemo.hdz.tinytaskdemo.rest.events;

/**
 * Created by chemo on 4/27/17.
 */

public class GetItemServiceEvent {
    private String category;
    private String item;

    public GetItemServiceEvent(String category, String item) {
        this.category = category;
        this.item = item;
    }

    public String getCategory() {
        return category;
    }

    public String getItem() {
        return item;
    }
}
