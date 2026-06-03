import com.srija.cinefix.features.booking.BookingView;
import com.srija.cinefix.features.signin.SigninView;
import com.srija.cinefix.features.signup.SignupView;
import com.srija.cinefix.features.theaters.TheaterDetailsView;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    SignupView suv = new SignupView();

    System.out.println("======================================================");
    System.out.println();
    System.out.println("                "+"WELCOME TO CINEFIX"+"               ");
    System.out.println();
    System.out.println("======================================================");

    suv.create();


//    while(true){
//        if(asIn.equals("supervisor")){
//            System.out.println("1)Add book \n 2)Booking");
//            String choice=sc.nextLine();
//            if(choice.equals("1")){
//                boolean isadd=tdv.addTheaterView();
//                if (isadd) break;
//
//            }
//            else if(choice.equals("2")){
//                bv.booking();
//                 break;
//            }
//            else{
//                System.out.println("Enter 1 or 2 ");
//            }
//        }
//    }



  }

