package com.chemo.hdz.tinytaskdemo.rest.responses;

/**
 * Created by chemo on 4/27/17.
 */

public class ItemResponse
{
    private String category;

    private Website website;

    private String item;

    private String zipcode;

    private String farmer_id;

    private String farm_name;

    private String l;

    private String suite;

    private Location_1 location_1;

    private String phone1;

    private String business;

    public String getCategory ()
    {
        return category;
    }

    public void setCategory (String category)
    {
        this.category = category;
    }

    public Website getWebsite ()
    {
        return website;
    }

    public void setWebsite (Website website)
    {
        this.website = website;
    }

    public String getItem ()
    {
        return item;
    }

    public void setItem (String item)
    {
        this.item = item;
    }

    public String getZipcode ()
    {
        return zipcode;
    }

    public void setZipcode (String zipcode)
    {
        this.zipcode = zipcode;
    }

    public String getFarmer_id ()
    {
        return farmer_id;
    }

    public void setFarmer_id (String farmer_id)
    {
        this.farmer_id = farmer_id;
    }

    public String getFarm_name ()
    {
        return farm_name;
    }

    public void setFarm_name (String farm_name)
    {
        this.farm_name = farm_name;
    }

    public String getL ()
    {
        return l;
    }

    public void setL (String l)
    {
        this.l = l;
    }

    public String getSuite ()
    {
        return suite;
    }

    public void setSuite (String suite)
    {
        this.suite = suite;
    }

    public Location_1 getLocation_1 ()
    {
        return location_1;
    }

    public void setLocation_1 (Location_1 location_1)
    {
        this.location_1 = location_1;
    }

    public String getPhone1 ()
    {
        return phone1;
    }

    public void setPhone1 (String phone1)
    {
        this.phone1 = phone1;
    }

    public String getBusiness ()
    {
        return business;
    }

    public void setBusiness (String business)
    {
        this.business = business;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [category = "+category+", website = "+website+", item = "+item+", zipcode = "+zipcode+", farmer_id = "+farmer_id+", farm_name = "+farm_name+", l = "+l+", suite = "+suite+", location_1 = "+location_1+", phone1 = "+phone1+", business = "+business+"]";
    }
}