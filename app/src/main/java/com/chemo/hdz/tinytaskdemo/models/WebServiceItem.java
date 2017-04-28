package com.chemo.hdz.tinytaskdemo.models;

/**
 * Created by chemo on 4/28/17.
 */

public class WebServiceItem {
    private String item;
    private String businessName;
    private String phone;
    private String website;
    private String zipcode;

    public WebServiceItem() {
        super();
    }

    public WebServiceItem(String item, String businessName, String phone, String website, String zipcode) {
        this.item = item;
        this.businessName = businessName;
        this.phone = phone;
        this.website = website;
        this.zipcode = zipcode;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
