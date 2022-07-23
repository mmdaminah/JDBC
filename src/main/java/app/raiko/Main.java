package app.raiko;

import app.raiko.controller.AdminServiceImp;
import app.raiko.model.dao.AdminJdbcDao;
import app.raiko.view.AdminFounderView;
import app.raiko.view.IndexView;

public class Main {

  public static void main(String[] args) {
    new IndexView(new AdminFounderView(new AdminServiceImp(new AdminJdbcDao()))).mainMenu();
  }
}
