package com.wadektech.el_muzarae.pojos;

public class Farmer {
    private String names ;
    private String phoneNumber ;
    private String region ;
    private String state ;
    private String county ;
    private String password ;

    public Farmer() {
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Farmer(String names, String phoneNumber, String region, String state, String county, String password) {
        this.names = names;
        this.phoneNumber = phoneNumber;
        this.region = region;
        this.state = state;
        this.county = county;
        this.password = password;
    }
}
