package com.srija.cinefix.features.booking;

import com.srija.cinefix.data.dto.Booking;
import com.srija.cinefix.data.dto.Viewer;
import com.srija.cinefix.data.dto.ViewerBooking;
import com.srija.cinefix.data.repository.CinefixDb;

import java.util.ArrayList;
import java.util.List;

class BookingListModel {
    BookingListView blv ;
    CinefixDb db =
            CinefixDb.getInstance();

    public BookingListModel(BookingListView blv) {
        this.blv = blv;
    }

    public List<Booking> bookingDetails(){
        List<Booking> list = db.getAdminBooking();
        return list;
    }
    public void bookDetails(){
        Viewer viewer =
                db.getCurrentViewer();
        int userId =
                viewer.getUser_id();
        List<ViewerBooking> list = db.getCustomerBook(userId);
        for(ViewerBooking l:list){
            blv.printBookDetails(l);
        }
    }
}
