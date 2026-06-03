package com.srija.cinefix.features.screen;

import com.srija.cinefix.data.dto.Movie;
import com.srija.cinefix.data.dto.Screen;
import com.srija.cinefix.data.dto.Theater;
import com.srija.cinefix.data.repository.CinefixDb;

import java.util.List;

class ScreenModel {
    CinefixDb db =
            CinefixDb.getInstance();

    public Screen getScreens(Theater t, Movie m) {
        List<Theater> theater = db.getTheater();

        for (Theater th : theater) {
            if (t.getTheater_name()
                    .equalsIgnoreCase(th.getTheater_name())) {

                int index = m.getScreen_no() - 1;
                if (index >= 0 &&
                        index < th.getScreen().size()) {

                    return th.getScreen().get(index);
                }
            }

        }
        return null;
    }
}
