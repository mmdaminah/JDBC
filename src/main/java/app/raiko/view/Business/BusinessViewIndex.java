package app.raiko.view.Business;

import app.raiko.controller.businessOwner.BusinessOwnerController;
import app.raiko.model.admin.domain.Admin;
import app.raiko.view.Business.Create.CreateBusinessOwner;

public class BusinessViewIndex {
    private final BusinessOwnerController businessOwnerController;
    private Admin connectedAdmin;

    public BusinessViewIndex(BusinessOwnerController businessOwnerController,Admin connectedAdmin) {
        this.businessOwnerController = businessOwnerController;
        this.connectedAdmin = connectedAdmin;
    }
    public void createBusinessOwner(){
        CreateBusinessOwner.create(businessOwnerController,connectedAdmin);
    }
}
