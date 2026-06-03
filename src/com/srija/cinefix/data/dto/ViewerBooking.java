package com.srija.cinefix.data.dto;

import java.util.List;

public class ViewerBooking {

    private static int idGenerator=1;



    private int booking_id;
    private String theater_name;
    private String movie_name;
    private int screen_no;
    private List<Integer> noSeat;



    public ViewerBooking(int bookingId,String theater_name,String movie_name,int screen_no,List<Integer> noSeat){
        this.booking_id = bookingId;
        this.theater_name = theater_name;
        this.movie_name = movie_name;
        this.screen_no = screen_no;
        this.noSeat = noSeat;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public String getTheater_name() {
        return theater_name;
    }

    public int getScreen_no() {
        return screen_no;
    }

    public List<Integer> getNoSeat() {
        return noSeat;
    }

    public int getBooking_id() {return booking_id;}

}
