package com.srija.cinefix.features.mainMenu;

import com.srija.cinefix.features.signup.SignupView;

public class MainMenuView {

    MainMenuModel mmm = new MainMenuModel();
    SignupView suv = new SignupView();

    public void init(String value){

        if(value.equals("supervisor")){
              mmm.adminOption();
              //Admin session ends here -no redirect to sign up screen

        }
        else if(value.equals("customer")){
              mmm.customerOption();
        }

    }
}
