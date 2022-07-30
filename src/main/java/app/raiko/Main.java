package app.raiko;

import app.raiko.controller.admin.AdminControllerImp;
import app.raiko.model.admin.dao.AdminDao;
import app.raiko.model.admin.dao.AdminJdbcDao;
import app.raiko.model.datasource.DataSource;
import app.raiko.view.IndexView;
import org.mindrot.jbcrypt.BCrypt;

public class Main {
  public static void main(String[] args) {
    var dataSource = new DataSource();
    var adminDao = new AdminJdbcDao(dataSource);
    var adminController = new AdminControllerImp(adminDao);
    var result = adminDao.usernameExits("karrt");
    System.out.println(result);

    IndexView.start();
  }
}
