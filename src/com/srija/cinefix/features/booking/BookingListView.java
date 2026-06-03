package com.srija.cinefix.features.booking;

import com.srija.cinefix.data.dto.Booking;
import com.srija.cinefix.data.dto.ViewerBooking;

import java.util.List;

public class BookingListView {

    BookingListModel blm = new BookingListModel(this);

    public void customerBookingDetails(){
        blm.bookDetails();
    }

    public void adminBookingDetails(){
          List<Booking> booking = blm.bookingDetails();

          if(booking.isEmpty()){
              System.out.println("No booking available.........");
              return;
          }

          System.out.println();
          System.out.println(" Movie         Theater        Time        Screen         Seats");
          System.out.println("-------------------------------------------------------------------");

          for(Booking b:booking){
              System.out.println(b.getMovie_name()+"           "+
                      b.getTheater_name()+"          "+
                      b.getShowTime()+"         "+
                      b.getScreen_no()+"          "+
                      b.getBooked());
          }

    }

    public void printBookDetails(ViewerBooking b){

        System.out.println("Booking id       theater name         movie name            screen         seats");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(
                b.getBooking_id()+"                  "+
                b.getTheater_name()+"              "
                +b.getMovie_name()+"              "
                +b.getScreen_no()+"                "
                +b.getNoSeat());
    }


}
