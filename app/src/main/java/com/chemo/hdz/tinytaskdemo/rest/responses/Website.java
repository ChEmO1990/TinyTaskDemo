package com.chemo.hdz.tinytaskdemo.rest.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by chemo on 4/27/17.
 */

public class Website
{
    private String url;

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    @Override
    public String toString()
    {
        return url;
    }
}