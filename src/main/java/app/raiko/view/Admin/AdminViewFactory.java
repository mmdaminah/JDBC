package app.raiko.view.Admin;

import app.raiko.controller.admin.AdminControllerImp;
import app.raiko.model.admin.dao.AdminJdbcDao;
import app.raiko.model.admin.domain.Admin;
import app.raiko.model.datasource.DataSource;

public class AdminViewFactory {
    public static AdminViewIndex create(Admin connectedAdmin){
        var dataSource = new DataSource();
        var adminDao = new AdminJdbcDao(dataSource);
        var adminController = new AdminControllerImp(adminDao);
        return new AdminViewIndex(adminController,connectedAdmin);
    }
}
