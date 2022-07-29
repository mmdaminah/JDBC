package app.raiko.view;

import app.raiko.view.Admin.AdminLogin.AdminLogin;
import app.raiko.view.Admin.SuperAdmin.SuperAdmin;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class IndexView {
  private SuperAdmin superAdmin;
  private AdminLogin adminLoginView;


  public void mainMenu() {
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

