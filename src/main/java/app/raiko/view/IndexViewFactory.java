package app.raiko.view;

import app.raiko.controller.admin.AdminControllerImp;
import app.raiko.model.admin.dao.AdminJdbcDao;
import app.raiko.model.datasource.DataSource;

public class IndexViewFactory {

  public static IndexView create() {
    var dataSource = new DataSource();
    var adminDao = new AdminJdbcDao(dataSource);
    var adminController = new AdminControllerImp(adminDao);
    var adminFounder = new AdminFounderView(adminController);

    return new IndexView(adminFounder);
  }
}
