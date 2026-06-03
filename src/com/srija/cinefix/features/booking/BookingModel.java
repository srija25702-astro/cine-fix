package com.srija.cinefix.features.booking;

import com.srija.cinefix.data.dto.Booking;
import com.srija.cinefix.data.dto.MovieSlot;
import com.srija.cinefix.data.dto.Seat;
import com.srija.cinefix.data.repository.CinefixDb;

import java.util.List;

class BookingModel{
    CinefixDb db =
            CinefixDb.getInstance();
    public MovieSlot getMovieSlot(String theaterName,String mName,String showTime,int screenNo){

        List<MovieSlot> movieSlots = db.getMovieSlot();

        for(MovieSlot ms : movieSlots){

        if(ms.getTheater().getTheater_name()
                .equalsIgnoreCase(theaterName)
                &&
                ms.getMovie().getMovie_name()
                        .equalsIgnoreCase(mName)
                &&
                ms.getShowTime()
                        .equals(showTime)
                &&
                ms.getScreen().getScreenNo() == screenNo){

            return ms;
        }
    }
        return null;
}

public boolean isSeatAvailable(MovieSlot ms,
                               int seatNo){

    List<Seat> seats = ms.getScreen().getSeatList();

    for(Seat seat : seats){

        if(seat.getSeatNo() == seatNo){

            return !seat.isBooked();
        }
    }

    return false;
}

public void bookSeat(MovieSlot ms,
                     int seatNo){

    List<Seat> seats = ms.getScreen().getSeatList();

    for(Seat seat : seats){

        if(seat.getSeatNo() == seatNo){

            seat.setBooked(true);
        }
    }
}

public void addBooking(Booking booking){
    db.addBooking(booking);
  }

    public boolean isthere(MovieSlot ms, int seatNo) {
        List<Seat> seats = ms.getScreen().getSeatList();

        if(seatNo>seats.size()){
            return false;
        }
        return true;
    }
}


