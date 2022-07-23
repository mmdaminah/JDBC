package app.raiko;

import app.raiko.view.IndexViewFactory;

public class Main {
  public static void main(String[] args) {
    IndexViewFactory.create().mainMenu();
  }
}
