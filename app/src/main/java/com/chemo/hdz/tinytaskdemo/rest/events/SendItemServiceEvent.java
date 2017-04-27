package com.chemo.hdz.tinytaskdemo.rest.events;

import com.chemo.hdz.tinytaskdemo.rest.responses.ItemResponse;

import java.util.List;

/**
 * Created by chemo on 4/3/17.
 */

public class SendItemServiceEvent {
    private List<ItemResponse> socratas;

    public SendItemServiceEvent(List<ItemResponse> socratas) {
        this.socratas = socratas;
    }

    public List<ItemResponse> getSocratas() {
        return socratas;
    }
}
