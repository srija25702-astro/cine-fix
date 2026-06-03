package com.srija.cinefix.data.dto;

import java.util.List;

public class MovieSlot {
    Theater t;
    Movie m;
    Screen s;
    private String showTime;


    public MovieSlot(Movie m,Theater t,String showTime,Screen s){
        this.m = m;
        this.t = t;
        this.showTime = showTime;
        this.s = s;
    }
    public Screen getScreen(){return s;}

    public Theater getTheater() {
        return t;
    }

    public Movie getMovie() {
        return m;
    }

    public String getShowTime() {
        return showTime;
    }



}
