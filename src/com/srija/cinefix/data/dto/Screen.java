package com.srija.cinefix.data.dto;

import java.util.List;

public class Screen {
    private int screenNo;
    private List<Seat> seatList;

    public Screen(int screenNo,List<Seat> s){
        this.screenNo = screenNo;
        this.seatList = s;
    }
    public int getScreenNo() {
        return screenNo;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }









}
