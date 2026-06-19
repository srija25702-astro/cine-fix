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
    public  List<Viewer> viewers=new ArrayList<>();
    public  List<Theater> theaters= new ArrayList<>();
    public  List<Booking> booked = new ArrayList<>();
    public  List<Movie> movie = new ArrayList<>();
    public  List<MovieSlot> movieSlot = new ArrayList<>();

    public static Viewer currentViewer;
    public static Admin admin = new Admin("srija2572","srija@gmail.com","srija257@2");

    public  List<Movie> getMovie() {
        return movie;
    }
    public  List<Booking> getBooked(){return booked;}
    public  List<MovieSlot> getMovieSlot(){
        return movieSlot;
    }

    //Movie slot exist
    public boolean isExistMovieSlot(MovieSlot ms){
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


    //get current viewer
    public Viewer getCurrentViewer(){

        return currentViewer;
    }

   //add movie slot
    public  boolean addMovieSlot(MovieSlot ms){
        movieSlot.add(ms);
        return true;

    }

    //theater
    public List<Theater> getTheater(){
        return theaters;
    }
    //booking
    public  List<Booking> getAdminBooking() {
        return booked;
    }


    // get particular booking
    public List<ViewerBooking> getCustomerBook(int id) {
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
    public boolean isExist(Viewer v){

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
    public  boolean isTheaterExist(Theater t) {

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

    public  boolean addTheater(Theater t){
           theaters.add(t);

           return true;
    }
    // add movie
    public boolean addMovies(Movie m){
        movie.add(m);
        return true;
    }

    //booking check



    public boolean getMovieExist(Movie m){
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
    public boolean isValidSlot(MovieSlot s){
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
    // Returns true if slot s and slot m overlap in time (bidirectional check)
    private static boolean overlaps(MovieSlot s, MovieSlot m){
        LocalTime mStart = LocalTime.parse(m.getShowTime());
        LocalTime mDur   = LocalTime.parse(m.getMovie().getDuration());
        LocalTime mEnd   = mStart.plusHours(mDur.getHour()).plusMinutes(mDur.getMinute());

        LocalTime sStart = LocalTime.parse(s.getShowTime());
        LocalTime sDur   = LocalTime.parse(s.getMovie().getDuration());
        LocalTime sEnd   = sStart.plusHours(sDur.getHour()).plusMinutes(sDur.getMinute());

        // Two intervals overlap if each starts before the other ends
        return sStart.isBefore(mEnd) && mStart.isBefore(sEnd);
    }
    // add booking
    public void addBooking(Booking b){
        booked.add(b);
    }
    // add viewer
    public void addViewer(Viewer v){
        viewers.add(v);
    }

}
