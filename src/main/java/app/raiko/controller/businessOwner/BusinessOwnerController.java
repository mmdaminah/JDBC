package app.raiko.controller.businessOwner;

import app.raiko.model.admin.domain.Admin;
import app.raiko.model.businessOwner.domain.BusinessOwner;

import java.util.List;

public interface BusinessOwnerController {


    boolean createBusinessOwner(Admin admin, BusinessOwner businessOwner);
    BusinessOwner searchBusinessOwner(String firstName, String lastName);
    List<BusinessOwner> getAllBusinessOwners();
}
