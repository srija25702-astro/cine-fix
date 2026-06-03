package com.srija.cinefix.features.signin;

import com.srija.cinefix.data.dto.LoginRequest;
import com.srija.cinefix.data.dto.Viewer;
import com.srija.cinefix.data.repository.CinefixDb;

import static com.srija.cinefix.data.repository.CinefixDb.admin;

class SigninModel {
    CinefixDb db =
            CinefixDb.getInstance();
       public String signIn(LoginRequest request){
           for(Viewer viewer : db.viewers){
               if(viewer.getUserName().
                       equals(request.getUserName())
                       && viewer.getPassword().
                       equals(request.getPassword())
                       && viewer.getEmail().
                       equals(request.getEmail())){

                   db.currentViewer = viewer;

                   return viewer.getRole();
               }
           }
           if(request.getUserName().
                   equals(admin.getUserName())
                   && request.getPassword().
                   equals(admin.getPassword())
                   && request.getEmail().
                   equals(admin.getEmail())){

               return admin.getRole();
           }
           return "notUser";
       }
}
