package app.raiko.view;

import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class IndexView {
  private AdminFounderView adminFounderView;

  public void mainMenu() {
    var continueApp = true;
      System.out.println(" hello welcome to test application !!!");

    System.out.println("""
                               1) found admin
                               """);

    System.out.println("your action : ");
    var operator = new Scanner(System.in).nextInt();

    switch (operator){
      case 1 -> adminFounderView.show();
    }


    }
}
