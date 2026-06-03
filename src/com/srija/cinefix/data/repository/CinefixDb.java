package com.srija.cinefix.data.repository;

import com.srija.cinefix.data.dto.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CinefixDb {
    private static CinefixDb instance;
    private CinefixDb(){

    }
    public static CinefixDb getInstance(){

        if(instance == null){

            instance = new CinefixDb();
        }

        return instance;
    }
    public static List<Viewer> viewers=new ArrayList<>();
    public static List<Theater> theaters= new ArrayList<>();
    public static List<Booking> booked = new ArrayList<>();
    public static List<Movie> movie = new ArrayList<>();
    public static List<MovieSlot> movieSlot = new ArrayList<>();
    public static List<Seat> seats= new ArrayList<>();
    public static Viewer currentViewer;
    public static Admin admin = new Admin("srija2572","srija@gmail.com","srija257@2");

    public static List<Movie> getMovie() {
        return movie;
    }
    public static List<Booking> getBooked(){return booked;}
    public static List<MovieSlot> getMovieSlot(){
        return movieSlot;
    }
    //Movie slot exist
    public static boolean isExistMovieSlot(MovieSlot ms){
        for(MovieSlot m_s : movieSlot){
            if(m_s.getTheater().getTheater_name().toLowerCase().
                    equals(ms.getTheater().getTheater_name().toLowerCase())
                    &&
                    m_s.getShowTime().
                            equals(ms.getShowTime()) &&
                    m_s.getScreen().getScreenNo()
                    == ms.getScreen().getScreenNo()){
                return true;
            }
        }
        return false;
    }

//    private static int[][] initialise() {
//        int[][] list = new int[5][5];
//        int v = 1;
//        for(int i=0;i<list.length;i++){
//            for(int j=0;j<list[i].length;j++){
//                list[i][j]=v++;
//            }
//        }
//        return list;
//    }
    //get current viewer
    public Viewer getCurrentViewer(){

        return currentViewer;
    }

   //add movie slot
    public static boolean addMovieSlot(MovieSlot ms){
        movieSlot.add(ms);
        return true;

    }

    //seats
    public static List<Seat> getSeats(){return seats;}
    //theater
    public static List<Theater> getTheater(){
        return theaters;
    }
    //booking
    public static List<Booking> getAdminBooking() {
        return booked;
    }


    // get particular booking
    public
    List<ViewerBooking> getCustomerBook(int id) {
        List<ViewerBooking> list=new ArrayList<>();
        for(Booking book : booked){
            if(book.getUser_id() == id){

                ViewerBooking vb =
                        new ViewerBooking(book.getBooking_id(),
                                book.getTheater_name(),
                                book.getMovie_name(),
                                book.getScreen_no(),
                                book.getBooked());

                list.add(vb);
            }
        }

        return list;
    }

    //viewer exist
    public  static boolean isExist(Viewer v){

        for(Viewer viewer : viewers){
            if(viewer.getUserName().
                    equals(v.getUserName())
                    &&
                    viewer.getPassword().
                            equals(v.getPassword())
                    &&
                    viewer.getUserName().
                            equals(admin.getUserName())
                    &&
                    viewer.getPassword().
                            equals(admin.getPassword())){

                return false;
            }
        }
        return true;
    }

    //thearter exist
    public static boolean isTheaterExist(Theater t) {

        for (Theater theater : theaters) {
            if (theater.getTheater_name().toLowerCase().
                    equals(t.getTheater_name().toLowerCase())
                    &&
                    theater.getLocation().toLowerCase().
                            equals(t.getLocation().toLowerCase())
                    ) {
                for(Screen s: t.getScreen()){
                    for(Screen s1:theater.getScreen()){
                        if(s.getScreenNo() == s1.getScreenNo()){
                            return true;
                        }
                    }
                }

            }

        }
        return false;
    }

    //add theater

    public static boolean addTheater(Theater t){
           theaters.add(t);
//           for(int i=0;i< theaters.size();i++){
//               System.out.println(theaters.get(i).getTheater_name());
//           }
           return true;
    }
    // add movie
    public static boolean addMovies(Movie m){
        movie.add(m);
        return true;
    }

    //booking check

//    public static boolean isBooked(Booking b){
//           for(Booking book:booked){
//               if(book.getTheater_name().equals(b.getTheater_name())
//                       && book.getMovie_name().equals(b.getMovie_name())
//                       && book.getScreen_no() == b.getScreen_no()
//                       && book.getNoSeat()== b.getNoSeat() && b.getIsBooked().equals("Booked")){
//                   return true;
//               }
//           }
//           return false;
//    }

    public static boolean getMovieExist(Movie m){
        for (Movie movies : movie) {
            if (movies.getDuration().equals(m.getDuration())
                    && movies.getMovie_name().trim().toLowerCase().equals(m.getMovie_name().toLowerCase())
                    && movies.getGenre().trim().toLowerCase().equalsIgnoreCase(m.getGenre()))
                    {
                return true;
            }

        }
        return false;
    }
    //is valid slot
    public static boolean isValidSlot(MovieSlot s){
        List<MovieSlot> movieSlots = getMovieSlot();

        for(MovieSlot ms:movieSlots){
            boolean flag=meanTime(s,ms);
            if(ms.getTheater().getTheater_name().toLowerCase().
                    equals(s.getTheater().getTheater_name().toLowerCase())
                    &&
                    ms.getScreen().getScreenNo() ==
                            s.getScreen().getScreenNo()
                    &&
                    flag){
                 return false;
            }
        }
        return true;
    }
    private static  boolean meanTime(MovieSlot s,MovieSlot m){
        LocalTime start = LocalTime.parse(m.getShowTime());
        LocalTime duration = LocalTime.parse(m.getMovie().getDuration());
        LocalTime result = start.plusHours(duration.getHour()).plusMinutes(duration.getMinute());
        LocalTime compareTime = LocalTime.parse(s.getShowTime());

        return compareTime.isBefore(result);

    }
    // add booking
    public static void addBooking(Booking b){
        booked.add(b);
    }
    // add viewer
    public static void addViewer(Viewer v){
        viewers.add(v);
    }

}
