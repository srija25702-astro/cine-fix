package com.srija.cinefix.features.cancel;

import com.srija.cinefix.data.dto.Booking;
import com.srija.cinefix.data.dto.Viewer;
import com.srija.cinefix.data.dto.ViewerBooking;
import com.srija.cinefix.data.repository.CinefixDb;

import java.util.List;
import java.util.Scanner;

public class CancelBookingView {
    CinefixDb db =
            CinefixDb.getInstance();
    CancelBookingModel cbm = new CancelBookingModel();
    Scanner sc = new Scanner(System.in);

    public void cancelBooking(){
        Viewer v = db.currentViewer;
        int user_id = v.getUser_id();

        List<ViewerBooking> list =
                db.getCustomerBook(user_id);

        System.out.println(
                "Enter booking id to cancel:"
        );

        int bookingId = sc.nextInt();

        Booking booking = cbm.getCorrectBooking(bookingId,user_id);
        if(booking == null){

            System.out.println(
                    "Booking not found..."
            );

            return;
        }

        cbm.cancelBooking(booking);

        System.out.println(
                "Booking cancelled successfully..."
        );
    }
}


