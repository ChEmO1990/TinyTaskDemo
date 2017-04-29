package com.chemo.hdz.tinytaskdemo.rest.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by chemo on 4/27/17.
 */

public class Location_1
{
    private String needs_recoding;
    private String longitude;
    private String latitude;
    private String human_address;

    public String getNeeds_recoding ()
    {
        return needs_recoding;
    }

    public void setNeeds_recoding (String needs_recoding)
    {
        this.needs_recoding = needs_recoding;
    }

    public String getLongitude ()
    {
        return longitude;
    }

    public void setLongitude (String longitude)
    {
        this.longitude = longitude;
    }

    public String getLatitude ()
    {
        return latitude;
    }

    public void setLatitude (String latitude)
    {
        this.latitude = latitude;
    }

    public String getHuman_address ()
    {
        return human_address;
    }

    public void setHuman_address (String human_address)
    {
        this.human_address = human_address;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [needs_recoding = "+needs_recoding+", longitude = "+longitude+", latitude = "+latitude+", human_address = "+human_address+"]";
    }
}