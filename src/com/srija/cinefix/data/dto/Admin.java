package com.srija.cinefix.data.dto;


public class Admin extends User{
    private String role = "supervisor";
    private int user_id = 1;
    public Admin(String username, String email, String password) {

        super(username,email,password);
    }
    public String getRole(){
        return role;
    }
}
