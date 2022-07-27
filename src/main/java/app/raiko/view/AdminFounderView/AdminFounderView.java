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
}