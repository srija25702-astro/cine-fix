package com.srija.cinefix.features.signup;

import com.srija.cinefix.data.dto.Viewer;
import com.srija.cinefix.data.repository.CinefixDb;

class SignupModel {
    CinefixDb db=CinefixDb.getInstance();

    public String validateUserName(String user){
        if(user == null || user.isEmpty()) {
            return "The user name cannot be empty.....";
        }
        user = user.trim();
        if(user.isEmpty()) {
            return "The user name cannot be empty.....";
        }
        if(user.length()<8){
            return "Enter username with 8 characters........";
        }
        return "";
    }

    public String validateEmail(String email){
        email = email.trim();
        if(email == null || email.isEmpty()){
            return "The email cannot be empty...........";
        }
        if(!email.contains("@") || !email.contains(".")){
            return "Enter a valid email address........";
        }
        int atIndex = email.indexOf("@");
        if(atIndex == 0 || atIndex == email.length() - 1){
            return "Enter a valid email address........";
        }
        return "";
    }

    public String validatePassword(String password,String confirmPassword){
        if(password == null || confirmPassword == null){
            return "Password cannot be null............";
        }
        password = password.trim();
        confirmPassword = confirmPassword.trim();
        if(password.isEmpty()){
            return "Password cannot be empty............";
        }
        if(password.length()<8 ){
            return "Password should be 8 or more than 8 characters........";
        }
        if(!(password.contains("@") || password.contains("$")|| password.contains("&")))
            return "Password should have special characters........";

        if(!password.equals(confirmPassword)) {
            return "Please confirm the password correctly........";

        }
        return "";
    }

    public void addViewer(Viewer v){
        db.addViewer(v);
    }
    public boolean isExist(Viewer v){
        return db.isExist(v);
    }
}
