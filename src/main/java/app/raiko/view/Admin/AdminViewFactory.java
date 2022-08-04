package app.raiko.view.Admin;

import app.raiko.controller.admin.AdminControllerImp;
import app.raiko.model.admin.dao.AdminJdbcDao;
import app.raiko.model.admin.domain.Admin;
import app.raiko.model.datasource.JdbcDataSource;

public class AdminViewFactory {
    public static AdminViewIndex create(Admin connectedAdmin){
        var dataSource = new JdbcDataSource();
        var adminDao = new AdminJdbcDao(dataSource);
        var adminController = new AdminControllerImp(adminDao);
        return new AdminViewIndex(adminController,connectedAdmin);
    }
}
