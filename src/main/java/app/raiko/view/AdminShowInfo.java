package app.raiko.view;

import app.raiko.model.admin.domain.Admin;
import lombok.AllArgsConstructor;


public class AdminShowInfo {


  public static void ShowInfo(Admin admin){


      if(admin==null){

          System.out.println("please login first!!!");
            return;
      }


      System.out.printf("""
                              first name : %s
                              last name : %s
                              username : %s
                              phone_number : %s
                              """,admin.getFirstName(),
              admin.getLastName(),
              admin.getUsername(),
              admin.getPhone_number());

      System.out.println("creator : %d\n isSuper : %b\n".formatted(admin.getCreator(),admin.getSuper_admin()));

   }
}
