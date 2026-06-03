package com.srija.cinefix.features.movieSlot;

import com.srija.cinefix.data.dto.Movie;
import com.srija.cinefix.data.dto.MovieSlot;
import com.srija.cinefix.data.dto.Screen;
import com.srija.cinefix.data.dto.Theater;


import java.util.List;
import java.util.Scanner;

public class MovieSlotView {

    MovieSlotModel msm = new MovieSlotModel(this);
    Scanner sc = new Scanner(System.in);

    //add movie slot
    public void addMovieSlot(){
        boolean flag = msm.addSlot();
        if(flag){
            System.out.println("Slot added successfully.............");
        }
        else{
            System.out.println("The slot is unavailable.......");
        }
    }

    // select elements for the movie slot
    public MovieSlot selectElement(List<Theater> t, List<Movie> m){
        int i = 0;
        for(Theater theater:t){
            System.out.println((i++)+")"+theater.getTheater_name());
        }
        System.out.print("Enter the Theater number: ");
        int theater=sc.nextInt();


        int j = 0;
        for(Movie movie:m){
            System.out.println((j++)+" )"+movie.getMovie_name());
        }

        System.out.print("Enter the Movie number:");
        int movie = sc.nextInt();
        sc.nextLine();



        System.out.print("Enter the show time :");
        String showTime = sc.nextLine();

        Theater selectedTheater = t.get(theater);
        Movie selectedMovie = m.get(movie);
        int screenNo = 0;

        while(true){
            System.out.print("Enter the screen number: ");
            screenNo = sc.nextInt();
            sc.nextLine();
            if(screenNo > selectedTheater.getScreen().size() || screenNo<=0){
                System.out.println("Enter the valid screen number........");
            }
            else{
                break;
            }
        }

        Screen s = selectedTheater.getScreen().get(screenNo - 1);
        MovieSlot ms = new MovieSlot(selectedMovie, selectedTheater,showTime,s);
        return ms;
    }

    public void viewDetails(){
        msm.giveSlot();
    }

    public void printViewDetails(MovieSlot ms){
        int screenNo = ms.getScreen().getScreenNo()-1;

        System.out.println(ms.getTheater().getTheater_name()+"               "+
                ms.getMovie().getMovie_name()+"              "+
                ms.getMovie().getDuration()+"                "+
                        (screenNo+1)+"                "+
                ms.getShowTime()
                );
    }
    public boolean screenCheck(String tName,String mName,int screenNo,String showTime){
        if(msm.validScreen(tName,mName,screenNo,showTime)){
            return true;
        }
        return false;
    }

}
