package com.srija.cinefix.features.theaters;

import com.srija.cinefix.data.dto.Theater;

public class TheaterListView {

    public void theaterDetails(){
       new TheaterListModel().theater();
    }

    public void printDetails(Theater t){
        System.out.println(t.getTheater_name()
                        +"                             " +
                        t.getLocation()
                        +"                                "+
                        t.getScreen().size()+"                 "
        );
    }
    public void details(){
        new TheaterListModel().theaters();
    }

}
