package com.srija.cinefix.features.seat;

import com.srija.cinefix.data.dto.MovieSlot;
import com.srija.cinefix.data.dto.Seat;

import java.util.List;

public class SeatView {

    public void displaySeats(MovieSlot movieSlot){
        List<Seat> seats = movieSlot.getScreen().getSeatList();

        for(Seat seat : seats){
            if(seat.isBooked()){
                System.out.print("X ");
            }
            else{
                System.out.print(seat.getSeatNo() + " ");
            }

            // next line after every 5 seats
            if( seat.getSeatNo() % 5 == 0){

                System.out.println();
            }
        }

        System.out.println();
    }
}
