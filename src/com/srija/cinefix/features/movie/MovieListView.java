package com.srija.cinefix.features.movie;

import com.srija.cinefix.data.dto.Movie;
import com.srija.cinefix.data.dto.Theater;

public class MovieListView {
    public void movieDetails(){
        new MovieListModel().movies();
    }
    public void printDetails(Movie m){
        System.out.println(m.getMovie_name()+"                         "
                + m.getDuration()+"                             "+
                m.getGenre()
                );
    }
}
