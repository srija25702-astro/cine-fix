package com.srija.cinefix.features.booking;

import com.srija.cinefix.data.dto.Booking;
import com.srija.cinefix.data.dto.MovieSlot;
import com.srija.cinefix.data.dto.Viewer;
import com.srija.cinefix.data.repository.CinefixDb;
import com.srija.cinefix.features.movieSlot.MovieSlotView;
import com.srija.cinefix.features.seat.SeatView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingView{
    CinefixDb db =
            CinefixDb.getInstance();
    Scanner sc = new Scanner(System.in);
    BookingModel bm = new BookingModel();
    MovieSlotView msv = new MovieSlotView();
    SeatView sv = new SeatView();
    Scanner s = new Scanner(System.in);

    public void booking(){

        msv.viewDetails();

        System.out.println();
        System.out.print("Enter theater name: ");
        String theaterName = s.nextLine();

        System.out.print("Enter movie name: ");
        String movieName = s.nextLine();

        System.out.print("Enter show time: ");
        String showTime = s.nextLine();

        System.out.print("Enter screen number: ");
        int screenNo = s.nextInt();
        s.nextLine();

        MovieSlot ms = bm.getMovieSlot(
                theaterName,
                movieName,
                showTime,
                screenNo
        );

        if(ms == null){
            System.out.println("Movie slot not found...");
            return;
        }
        System.out.println();
        System.out.println("Seat Arrangement");
        System.out.println("----------------------");

         sv.displaySeats(ms);

        System.out.println();
        System.out.print("Enter number of seats: ");
    int noSeats = sc.nextInt();

    List<Integer> bookedSeats = new ArrayList<>();

        for(int i = 0; i < noSeats; i++){

        System.out.print("Enter seat number: ");
        int seatNo = sc.nextInt();
        boolean isThere =bm.isthere(ms,seatNo);

        boolean available = bm.isSeatAvailable(ms, seatNo);

        if(available){

            bookedSeats.add(seatNo);
        }
        else if(!isThere) {
                System.out.println("Enter valid seat number......");
            }
        else{
            System.out.println("Seat already booked...");
            i--;
        }
    }

        for(Integer seatNo : bookedSeats){
        bm.bookSeat(ms, seatNo);
    }
        Viewer v = db.getCurrentViewer();
        Booking booking = new Booking(
            v.getUser_id(),
            theaterName,
            movieName,
            showTime,
            screenNo,
            bookedSeats
    );

        bm.addBooking(booking);

        System.out.println();
        System.out.println("Booking Successful...");

        System.out.println("=====================================================================================");
        System.out.println("                                  Ticket                                              ");
        System.out.println("         Movie     : " + movieName);
        System.out.println("         Theater   : " + theaterName);
        System.out.println("         Show Time : " + showTime);
        System.out.println("         Screen No : " + screenNo);
        System.out.println("         Seats     : " + bookedSeats);
        System.out.println("========================================================================================");
        System.out.println();
}
}
