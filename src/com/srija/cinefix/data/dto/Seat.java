package com.srija.cinefix.data.dto;

public class Seat {
    private int seatNo;
    public Seat(int seat){
        this.seatNo = seat;

    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    private boolean isBooked = false;

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public boolean isBooked() {
        return isBooked;
    }





}
