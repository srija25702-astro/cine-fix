package com.srija.cinefix.data.dto;

import java.util.ArrayList;
import java.util.List;



public class Theater {
    private static int idGenerator = 1;
    private List<Screen> screenList = new ArrayList<>();
    private int theater_id;
    private String theater_name;
    private String location;


    public Theater() {
    }

    public Theater(String theater_name, String location, List<Screen> s) {
        this.theater_id = idGenerator++;
        this.theater_name = theater_name;
        this.location = location;
        this.screenList = s;
    }


    public String getLocation() {
        return location;
    }

    public List<Screen> getScreen() {
        return screenList;
    }

    public String getTheater_name() {
        return theater_name;
    }

    public int getTheater_id() {
        return theater_id;
    }
}



