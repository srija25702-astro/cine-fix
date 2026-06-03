package com.srija.cinefix.features.movie;

import java.util.Scanner;

public class MovieView {
    MovieModel mm = new MovieModel();
    Scanner sc = new Scanner(System.in);

    public void addMovieDetails(){

        System.out.print("Enter the movie name : ");
        String movieName = sc.nextLine();

        System.out.print("Enter the duration : ");
        String duration = sc.nextLine();

        System.out.print("Enter the genre : ");
        String genre = sc.nextLine();

        boolean flag = mm.addMovie(movieName,duration,genre);
        if(flag){
            System.out.println("Movie added successfully.......");
        }
        else{
            System.out.println("Movie already exist.......");
        }
    }
}
