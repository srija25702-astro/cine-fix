package com.srija.cinefix.features.cancel;

import com.srija.cinefix.data.dto.Booking;
import com.srija.cinefix.data.dto.MovieSlot;
import com.srija.cinefix.data.dto.Seat;
import com.srija.cinefix.data.dto.ViewerBooking;
import com.srija.cinefix.data.repository.CinefixDb;

import java.util.List;

class CancelBookingModel {
    CinefixDb db =
            CinefixDb.getInstance();
    public Booking getCorrectBooking(int bookId,int userId){

        for(Booking b : db.getBooked()){

            if(b.getBooking_id() == bookId
                    &&
                    b.getUser_id() == userId){

                return b;

            }
        }
        return null;
    }
    public void cancelBooking(
            Booking booking){

        List<MovieSlot> movieSlots =
                db.getMovieSlot();

        for(MovieSlot ms : movieSlots){

            boolean sameMovie =
                    ms.getMovie()
                            .getMovie_name()
                            .equalsIgnoreCase(
                                    booking.getMovie_name());
            boolean sameTheater =
                    ms.getTheater()
                            .getTheater_name()
                            .equalsIgnoreCase(
                                    booking.getTheater_name());

            boolean sameScreen =
                    ms.getScreen()
                            .getScreenNo()
                            == booking.getScreen_no();

            if(sameMovie
                    &&
                    sameTheater
                    &&
                    sameScreen){

                for(Integer seatNo :booking.getBooked()){

                    for(Seat seat :
                            ms.getScreen().getSeatList()){

                    if(seat.getSeatNo()
                            == seatNo){

                        seat.setBooked(false);
                    }
                }
            }
        }
    }

        db.getBooked().remove(booking);
}

}
