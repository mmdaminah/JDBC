package app.raiko.view;

import app.raiko.model.admin.domain.Admin;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AdminShowInfo {
    AdminLogin adminLogin=null;

  public void ShowInfo(){


      if(adminLogin.getAdmin()==null){

          System.out.println("please login first!!!");
            return;
      }

     else if (adminLogin.getAdmin().getCreator()==null){
          adminLogin.getAdmin().setCreator(0);
      }
      System.out.printf("""
                              first name : %s
                              last name : %s
                              username : %s
                              phone_number : %s
            
                              %n""",adminLogin.getAdmin().getFirstName(),
              adminLogin.getAdmin().getLastName(),
              adminLogin.getAdmin().getUsername(),
              adminLogin.getAdmin().getPhone_number());
   }
}
