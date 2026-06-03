package com.srija.cinefix.features.movieSlot;

import com.srija.cinefix.data.dto.Movie;
import com.srija.cinefix.data.dto.MovieSlot;
import com.srija.cinefix.data.dto.Screen;
import com.srija.cinefix.data.dto.Theater;
import com.srija.cinefix.data.repository.CinefixDb;

import java.util.List;

class MovieSlotModel {
    CinefixDb db =
            CinefixDb.getInstance();
    MovieSlotView msv;
    public MovieSlotModel(MovieSlotView msv){
        this.msv=msv;
    };

    public boolean addSlot(){
         List<Theater> t = db.getTheater();
         List<Movie> m = db.getMovie();
         MovieSlot s = msv.selectElement(t,m);
         boolean flag = db.isExistMovieSlot(s);
         if(flag){
             return false;
         }
         else{
             boolean isValid = db.isValidSlot(s);
             if(!isValid) return false;
             else{
                 boolean isAdded = db.addMovieSlot(s);
                 if(isAdded) return true;
             }

         }
         return false;
    }
    public void giveSlot(){
        List<MovieSlot> movieSlot = db.getMovieSlot();

        System.out.println("Theater name       "+"Movie Name      "+"Movie duration      "+"Screen number        "+"Show Time     ");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        for(MovieSlot ms:movieSlot){
            msv.printViewDetails(ms);
        }
    }
    public boolean validScreen(String tName,String mName,int screenNo,String showTime){
        List<MovieSlot> movieSlot = db.getMovieSlot();
        for(MovieSlot ms:movieSlot){
            if(ms.getTheater().getTheater_name().
                    equals(tName)
                    &&
                    ms.getMovie().getMovie_name().
                    equals(mName)
                    &&
                    ms.getScreen().getScreenNo() == screenNo
                    &&
                    ms.getShowTime().
                            equals(showTime)){
                return true;
            }
        }
        return false;
    }

}
