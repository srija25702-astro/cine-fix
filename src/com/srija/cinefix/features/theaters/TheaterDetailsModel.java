package com.srija.cinefix.features.theaters;

import com.srija.cinefix.data.dto.Screen;
import com.srija.cinefix.data.dto.Theater;
import com.srija.cinefix.data.repository.CinefixDb;

import java.util.List;

class TheaterDetailsModel {
    CinefixDb db =
            CinefixDb.getInstance();
     public boolean addTheater(String t_name, String location, List<Screen> s){
         Theater t = new Theater(t_name,location,s);

         boolean isTheaterExist = db.isTheaterExist(t);
         if(isTheaterExist){
            return false;

         }
         else{
             boolean isadded = db.addTheater(t);
             if(isadded) return true;
         }
         return false;
     }
}
