package com.srija.cinefix.features.seat;

import com.srija.cinefix.data.dto.MovieSlot;
import com.srija.cinefix.data.repository.CinefixDb;

import java.util.List;

class SeatModel {
    CinefixDb db =
            CinefixDb.getInstance();



//    public int seatDisplay(String tName,String mName,int screenNo){
//
//        List<MovieSlot> movieSlot = db.getMovieSlot();
//        for(MovieSlot ms:movieSlot){
//            if(ms.getTheater().getTheater_name().
//                    equals(tName) &&
//                      ms.getMovie().getMovie_name().
//                              equals(mName)
//                    && ms.getScreen().getScreenNo()== screenNo
//                    ){
//                return ms.getScreen().getSeatList().size();
//            }
//        }
//        return 0;
//    }
}
