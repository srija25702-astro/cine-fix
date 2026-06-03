package com.srija.cinefix.features.mainMenu;

import com.srija.cinefix.features.booking.BookingListView;
import com.srija.cinefix.features.booking.BookingView;
import com.srija.cinefix.features.cancel.CancelBookingView;
import com.srija.cinefix.features.movie.MovieListView;
import com.srija.cinefix.features.movie.MovieView;
import com.srija.cinefix.features.movieSlot.MovieSlotView;
import com.srija.cinefix.features.theaters.TheaterDetailsView;
import com.srija.cinefix.features.theaters.TheaterListView;

import java.util.Scanner;

class MainMenuModel {

    TheaterDetailsView tdv =new TheaterDetailsView();
    TheaterListView tlv = new TheaterListView();
    MovieListView mlv = new MovieListView();
    BookingListView blv = new BookingListView();
    BookingView bv = new BookingView();
    MovieView mv = new MovieView();
    MovieSlotView msv = new MovieSlotView();
    CancelBookingView cbv = new CancelBookingView();

   Scanner sc = new Scanner(System.in);

    public void adminOption(){
        String choice = "";
        do {
            System.out.println("1) Add theater \n2) view booking details\n3) view theater details\n4) Add Movie\n5) View Movie Details\n6) Add movie slot\n7)View Details\n8)Exit");
            System.out.print("Enter your choice : ");
            choice = sc.nextLine();
            if (choice.equals("1")) {
                tdv.addTheaterView();
            } else if (choice.equals("2")) {
                blv.adminBookingDetails();
            } else if (choice.equals("3")) {
                tlv.theaterDetails();
            } else if (choice.equals("4")) {
                mv.addMovieDetails();
            }
            else if(choice.equals("5")){
                mlv.movieDetails();
            }
            else if(choice.equals("6")){
                msv.addMovieSlot();
            }
            else if(choice.equals("7")){
                msv.viewDetails();
            }
        }while(!choice.equals("8"));


    }
    public void customerOption() {
           String choice = "";
           do{
            System.out.println("1) View theaters\n2) Booking\n3) booked details\n4) Cancel Booking\n5) Exit");
            System.out.print("Enter your choice : ");
            choice = sc.nextLine();
            if (choice.equals("1")) {
                msv.viewDetails();
            } else if (choice.equals("2")) {
                bv.booking();
            } else if (choice.equals("3")) {
                blv.customerBookingDetails();
            }
            else if(choice.equals("4")){
                cbv.cancelBooking();
            }
        }while(!choice.equals("5"));

    }
}
