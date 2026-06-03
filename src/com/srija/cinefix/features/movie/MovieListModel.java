package com.srija.cinefix.features.movie;

import com.srija.cinefix.data.dto.Movie;
import com.srija.cinefix.data.dto.Theater;
import com.srija.cinefix.data.repository.CinefixDb;

import java.util.List;

class MovieListModel {
    CinefixDb db =
            CinefixDb.getInstance();
    MovieListView mlv = new MovieListView();

    public void movies(){
        List<Movie> list = db.getMovie();

        System.out.println("Movie name            "+"     Duration       "+"                     genre       ");
        System.out.println("------------------------------------------------------------------------------------------------------------------");

        for (Movie l : list) {
            mlv.printDetails(l);
        }
    }
}
