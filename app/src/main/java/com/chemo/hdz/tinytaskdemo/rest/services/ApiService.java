package com.chemo.hdz.tinytaskdemo.rest.services;

import com.chemo.hdz.tinytaskdemo.rest.responses.ItemResponse;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;


/**
 * Created by chemo on 4/27/17.
 */

public interface ApiService {
    @GET("/")
    void getItems(@Query("category") String category, @Query("item") String item, Callback<List<ItemResponse>> callBack);
}
