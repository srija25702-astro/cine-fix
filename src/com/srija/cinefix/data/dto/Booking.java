package com.srija.cinefix.data.dto;

import java.util.List;



public class Booking {
   private static int count=1;
    private int user_id;
    private int booking_id;
    private String theater_name;
    private String movie_name;
    private int screen_no;
    private String showTime;
    private List<Integer> booked;


    public Booking(int userId,String theater_name, String movie_name, String showTime,int screen_no, List<Integer> booked){
        this.user_id = userId;
        this.booking_id = count++;
        this.theater_name = theater_name;
        this.movie_name = movie_name;
        this.showTime = showTime;
        this.screen_no = screen_no;
        this.booked = booked;

    }
    public String getShowTime() {
        return showTime;
    }

    public List<Integer> getBooked(){return booked;}

    public int getUser_id() {
        return user_id;
    }

    public int getBooking_id() {
        return booking_id;
    }

    public String getTheater_name() {return theater_name;}

    public String getMovie_name() {return movie_name;}

    public int getScreen_no() {return screen_no;}




}
