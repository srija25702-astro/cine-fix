package com.srija.cinefix.data.dto;

public class LoginRequest {

    private String username;
    private String email;
    private String password;

    public LoginRequest(String username,String email,String password){
        this.username = username;
          this.email = email;
          this.password = password;
    }
    public String getUserName() {return username;}

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


}
