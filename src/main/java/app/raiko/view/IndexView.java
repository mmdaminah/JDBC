package app.raiko.view;

import app.raiko.view.Login.AdminLogin.AdminLogin;
import app.raiko.view.Login.LoginViewFactory;
import app.raiko.view.Login.LoginViewIndex;
import app.raiko.view.Login.SuperAdmin.SuperAdmin;
import app.raiko.view.Menu.AdminMenu;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class IndexView {

  public static void start() {
    var loginView = LoginViewFactory.create();
    if(!loginView.isSuperAdminAvailable()){
        loginView.createSuperAdmin();
    }
    var connectedAdmin = loginView.login();
    connectedAdmin.ifPresent(AdminMenu::MainMenu);
  }
}

