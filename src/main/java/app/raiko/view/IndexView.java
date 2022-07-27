package app.raiko.view;

import app.raiko.view.AdminFounderView.AdminFounderView;
import app.raiko.view.AdminLogin.AdminLogin;
import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class IndexView {
  private AdminFounderView adminFounderView;
  private AdminLogin adminLoginView;



  public void mainMenu() {
    var continueApp = true;


    System.out.println("""
                              please login
                               """);
        adminLoginView.show();

  }
}

