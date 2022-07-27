package app.raiko.view;

import app.raiko.controller.admin.AdminControllerImp;
import app.raiko.model.admin.dao.AdminJdbcDao;
import app.raiko.model.datasource.DataSource;
import app.raiko.view.AdminChangePassword.AdminChangePassword;
import app.raiko.view.AdminFounderView.AdminFounderView;
import app.raiko.view.AdminLogin.AdminLogin;
import app.raiko.view.AdminShow.AdminShowInfo;
import app.raiko.view.AdminShow.ShowAllAdmins;
import app.raiko.view.CreateAdmin.CreateAdmin;
import app.raiko.view.SuperAdmin.SuperAdmin;
import app.raiko.view.Menu.AdminMenu;

public class IndexViewFactory {

  public static IndexView create() {
    var dataSource = new DataSource();
    var adminDao = new AdminJdbcDao(dataSource);
    var adminController = new AdminControllerImp(adminDao);
    var adminFounder = new AdminFounderView(adminController);
    var adminInfo = new AdminShowInfo();
    var showAllAdmins=new ShowAllAdmins(adminController);
    var superAdmin = new SuperAdmin(adminController);
    var createAdmin = new CreateAdmin(adminController);
    var changePassword = new AdminChangePassword(adminController);
    var adminMenu=new AdminMenu(adminInfo,showAllAdmins,createAdmin,changePassword);
    var adminLogin = new AdminLogin(adminController,null,adminMenu);

    return new IndexView(superAdmin,adminLogin);
  }
}
