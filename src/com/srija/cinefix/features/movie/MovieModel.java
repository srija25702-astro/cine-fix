package com.srija.cinefix.features.movie;

import com.srija.cinefix.data.dto.Movie;
import com.srija.cinefix.data.repository.CinefixDb;

class MovieModel {
    CinefixDb db =
            CinefixDb.getInstance();
    public boolean addMovie(String movieName, String movieDuration,  String genre) {
        Movie m = new Movie(movieName,movieDuration,genre);
        boolean isExist = db.getMovieExist(m);
        if(isExist){
            return false;
        }
        else{
            boolean isAdded = db.addMovies(m);
            if(isAdded) return true;
        }
        return false;
    }
}
