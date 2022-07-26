package app.raiko.view;

import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class IndexView {
  private AdminFounderView adminFounderView;
  private AdminLogin adminLoginView;

  public void mainMenu() {
    var continueApp = true;
      System.out.println(" hello welcome to test application !!!");

    System.out.println("""
                               1) found admin
                               2)login
                               """);

    System.out.println("your action : ");
    var operator = new Scanner(System.in).nextInt();

    switch (operator){
      case 1 -> adminFounderView.show();
    } switch (operator){
      case 2 -> adminLoginView.show();
    }


    }
}
