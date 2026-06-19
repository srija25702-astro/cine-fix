package com.srija.cinefix.features.theaters;

import com.srija.cinefix.data.dto.Screen;
import com.srija.cinefix.data.dto.Seat;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheaterDetailsView {

    TheaterDetailsModel tdm = new TheaterDetailsModel();
    Scanner sc = new Scanner(System.in);


     public boolean addTheaterView(){

         System.out.print("Enter the Theater Name: ");
         String theaterName=sc.nextLine().trim();

         System.out.print("Enter the Theater location: ");
         String theaterLocation=sc.nextLine().trim();

         int noScreen=0;
         do{
             System.out.print("Enter the number of screen(1 or 2) : ");
             noScreen = sc.nextInt();
             if(noScreen != 1 && noScreen != 2){
                 System.out.println(" Enter the valid number of screen: ");
             }
         }while(noScreen != 1 && noScreen != 2);


         sc.nextLine();
         List<Screen> screens = new ArrayList<>();

         for(int i = 1; i <= noScreen; i++) {
             System.out.print("Enter the screen number ( 1 or 2):");
             int screenNo = sc.nextInt();

             System.out.print("Enter the seat capacity: ");
             int seatCapacity = sc.nextInt();
             sc.nextLine();

             List<Seat> seats = new ArrayList<>();
             for(int k = 1; k <= seatCapacity; k++){
                 seats.add(new Seat(k));
             }
             screens.add(new Screen(screenNo, seats));
         }

         boolean flag = tdm.addTheater(theaterName,theaterLocation,screens);
         if(flag){
             System.out.println("Theater added successfully......");
         }
         else{
             System.out.println("Theater already exist........");
         }
         return flag;
     }
}
