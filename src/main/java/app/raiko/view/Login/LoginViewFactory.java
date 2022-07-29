package app.raiko.view.Login;

import app.raiko.controller.admin.AdminControllerImp;
import app.raiko.model.admin.dao.AdminJdbcDao;
import app.raiko.model.datasource.DataSource;

public class LoginViewFactory {
    public static LoginViewIndex create(){
        var dataSource = new DataSource();
        var adminDao = new AdminJdbcDao(dataSource);
        var adminController = new AdminControllerImp(adminDao);
        return new LoginViewIndex(adminController);
    }
}
