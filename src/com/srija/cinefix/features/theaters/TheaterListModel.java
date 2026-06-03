package com.srija.cinefix.features.theaters;

import com.srija.cinefix.data.dto.Booking;
import com.srija.cinefix.data.dto.Theater;
import com.srija.cinefix.data.repository.CinefixDb;

import java.util.List;

class TheaterListModel {
    CinefixDb db =
            CinefixDb.getInstance();

    TheaterListView tlv = new TheaterListView();

    public void theater() {
        List<Theater> list = db.getTheater();
        System.out.println("Theater name                 Theater location               number of screen         ");
        System.out.println("------------------------------------------------------------------------------------------------------------------");

        for (Theater l : list) {
            tlv.printDetails(l);
        }


    }
    public void theaters() {
            List<Theater> list = db.getTheater();
            System.out.println("Theater name                 Theater location              number of screen      ");
            System.out.println("-----------------------------------------------------------------------------------------");
            for (Theater l : list) {
                tlv.printDetails(l);
            }


        }
}
