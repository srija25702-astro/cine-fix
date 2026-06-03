package com.srija.cinefix.features.signup;

import com.srija.cinefix.data.dto.Viewer;
import com.srija.cinefix.data.repository.CinefixDb;
import com.srija.cinefix.features.booking.BookingView;
import com.srija.cinefix.features.mainMenu.MainMenuView;
import com.srija.cinefix.features.signin.SigninView;
import com.srija.cinefix.features.theaters.TheaterDetailsView;

import java.util.Scanner;

public class SignupView {
     Scanner sc = new Scanner(System.in);
     public void create(){

         SignupModel s = new SignupModel();
         SigninView siv = new SigninView();
         Scanner sc = new Scanner(System.in);



         while(true) {
             String ans = null;
             System.out.println("1)  sign in \n2)  signup \n3)  Exit");
             System.out.print("Enter your choice : ");
             ans = sc.nextLine();

             String asIn = "";

             if (ans.equals("1")) {

                 siv.init();

             } else if (ans.equals("2")) {
                 while (true) {
                     String user ="";
                     String email = "";
                     String password = "";
                     String confirmPassword = "";

                     boolean userCheck = false;
                     boolean emailCheck = false;
                     boolean passwordcheck = false;
                     for(;;){

                         System.out.print("Enter your username: ");
                         user = sc.nextLine();

                         String check = s.validateUserName(user);
                         if(check.isEmpty()) {
                             userCheck = true;
                             break;
                         }
                         else{
                             System.out.println(check);
                         }
                     }

                    for(;;){

                        System.out.print("Enter your email: ");
                        email = sc.nextLine();

                        String check = s.validateEmail(email);

                        if(check.isEmpty()){
                            emailCheck = true;
                            break;
                        }
                        else{
                            System.out.println(check);
                        }
                    }

                    for(;;){
                        System.out.print("Enter your password: ");
                        password = sc.nextLine();

                        System.out.print("Please confirm  your password: ");
                        confirmPassword = sc.nextLine();

                        String check = s.validatePassword(password, confirmPassword);

                        if(check.isEmpty()){
                            passwordcheck = true;
                            break;
                        }
                        else{
                            System.out.println(check);
                        }
                    }

                     if (userCheck && passwordcheck && emailCheck) {
                         Viewer v = new Viewer(user, email, password);

                         boolean exist = CinefixDb.isExist(v);
                         if (exist) {
                             s.addViewer(v);
                             System.out.println("Signup successfull.........");
                             break;
                         } else {
                             System.out.println("Account alreadyexist.........");

                         }
                     }
                 }


             }
             else if(ans.equals("3")) {
                 System.out.println("Thank you for using cinefix");
                 break;
             }
//             value=asIn;
//             mmv.init(value);
         }
         //mmv.init(value);


     }
}
