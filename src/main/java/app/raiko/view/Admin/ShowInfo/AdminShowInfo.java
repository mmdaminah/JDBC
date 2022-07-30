package app.raiko.view.Admin.ShowInfo;

import app.raiko.model.admin.domain.Admin;


public class AdminShowInfo {
  public static void show(Admin admin){
      if(admin==null){
          System.out.println("please login first!!!");
            return;
      }
      System.out.printf("""
                           first name : %s
                           last name : %s
                           username : %s
                           phone_number : %s
                           creator :
                               ID : %d 
                               First Name : %s
                               Last Name : %s
                           isSuper : %b%n
                           """,
              admin.getFirstName(),
              admin.getLastName(),
              admin.getUsername(),
              admin.getPhoneNumber(),
              admin.getCreator().getId(),
              admin.getCreator().getFirstName(),
              admin.getCreator().getLastName(),
              admin.getSuperAdmin());
   }
}
