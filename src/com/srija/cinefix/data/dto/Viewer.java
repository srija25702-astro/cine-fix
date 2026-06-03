package com.srija.cinefix.data.dto;

public class Viewer extends User{


    private String role = "customer";
    private static int idGenerator = 2;
    private int user_id;


    public Viewer(String user_name,String email,String password){
        super(user_name, email,password);
        this.user_id = idGenerator++;

    }
    public String getRole() {
        return role;
    }

    public int  getUser_id() {return user_id;}





}
