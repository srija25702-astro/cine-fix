package com.srija.cinefix.features.screen;

import com.srija.cinefix.data.dto.Movie;
import com.srija.cinefix.data.dto.Screen;
import com.srija.cinefix.data.dto.Theater;

public class ScreenView {
    ScreenModel sm = new ScreenModel();

    public Screen toGetScreen(Theater t, Movie m){
        Screen s=sm.getScreens(t,m);
        return s;
    }
}
