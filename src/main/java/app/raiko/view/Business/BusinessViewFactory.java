package app.raiko.view.Business;

import app.raiko.controller.businessOwner.BusinessOwnerControllerImp;
import app.raiko.model.admin.domain.Admin;
import app.raiko.model.businessOwner.dao.BusinessOwnerJdbcDao;
import app.raiko.model.datasource.DataSource;

public class BusinessViewFactory {

    public static BusinessViewIndex create(Admin admin){
        var dataSource = new DataSource();
        var businessDao=new BusinessOwnerJdbcDao(dataSource);
        var businessController=new BusinessOwnerControllerImp(businessDao);
        return new BusinessViewIndex(businessController,admin);
    }

}
