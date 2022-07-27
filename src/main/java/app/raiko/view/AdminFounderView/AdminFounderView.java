package app.raiko.view.AdminFounderView;

import app.raiko.controller.admin.AdminController;
import app.raiko.exception.NotFoundAdminException;
import app.raiko.model.admin.domain.Admin;
import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class AdminFounderView {

  private AdminController adminController;

  public void show() {
    System.out.println("please enter admin id : ");
    var adminId = new Scanner(System.in).nextInt();

    try {

      var foundAdmin = adminController.findAdmin(adminId);

      showAdminInformation(foundAdmin);

    } catch (NotFoundAdminException e) {
      showError(e.getMessage());
    }
  }

  private void showError(String message) {
    System.out.println(message);
  }

  private void showAdminInformation(Admin admin) {
    System.out.printf("""
                              first name : %s
                              last name : %s
                              username : %s
                              password : %s
                              %n""", admin.getFirstName(),
                      admin.getLastName(),
                      admin.getUsername(),
                      admin.getPassword());
  }

  public void createAdmin(Admin loginedAdmin){
    var reader = new Scanner(System.in);
    System.out.println("Please insert first name : ");
    var firstName = reader.next();
    System.out.println("Please insert last name : ");
    var lastName = reader.next();
    System.out.println("Please insert username : ");
    var username = reader.next();
    System.out.println("Please insert password : ");
    var password = reader.next();
    System.out.println("Please insert phone number : ");
    var phoneNumber = reader.next();
    Integer creator;
    boolean superAdmin;
    if(loginedAdmin == null){
      creator = null;
      superAdmin = true;
    }
    else {
      creator = loginedAdmin.getCreator();
      superAdmin = false;
    }
    try{
      var result = adminController.createAdmin(
              new Admin(
                      0,
                      firstName,lastName,
                      username, password,
                      phoneNumber,creator,superAdmin
              )
      );
      System.out.println(result);
    }
    catch (RuntimeException e){
      showError(e.getMessage());
    }
  }
  public boolean getSuperAdmin(){
    return adminController.findSuperAdmin();
  }
}
