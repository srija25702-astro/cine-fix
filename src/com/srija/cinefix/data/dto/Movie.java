package com.srija.cinefix.data.dto;

public class Movie {
    private static int idGenerator=1;
    private int movie_id;
    private String movie_name;
    private String genre;

    private String duration;
    private int screen_no;


    public Movie(String name,String duration,String genre){
        this.movie_id = idGenerator++;
        this.movie_name = name;
        this.duration = duration;
        this.genre = genre;
    }

    public Movie() {

    }

    public int getScreen_no() {
        return screen_no;
    }

    public void setScreen_no(int screen_no) {
        this.screen_no = screen_no;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public String getGenre() {
        return genre;
    }

    public String getDuration() {
        return duration;
    }



}
