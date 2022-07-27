package app.raiko.view;

import app.raiko.view.AdminLogin.AdminLogin;
import app.raiko.view.CreateAdmin.CreateAdmin;
import app.raiko.view.SuperAdmin.SuperAdmin;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class IndexView {
  private SuperAdmin superAdmin;
  private AdminLogin adminLoginView;


  public void mainMenu() {
    var continueApp = true;
    var superAdminAvailable = superAdmin.getSuperAdmin();
    if(!superAdminAvailable){
      System.out.println("No Super Admin Found!");
      System.out.println("Creating Super Admin...");
      superAdmin.show();
    }

    System.out.println("""
                              please login
                               """);
        adminLoginView.show();

  }
}

