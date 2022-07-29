package app.raiko.controller.businessOwner;

import app.raiko.exception.NotFoundException;
import app.raiko.model.admin.domain.Admin;
import app.raiko.model.businessOwner.dao.BusinessOwnerDao;
import app.raiko.model.businessOwner.domain.BusinessOwner;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor

public class BusinessOwnerControllerImp implements BusinessOwnerController{
    private BusinessOwnerDao businessOwnerDao;
    @Override
    public boolean createBusinessOwner(Admin admin, BusinessOwner businessOwner) {
        return businessOwnerDao.create_businessOwner(admin,businessOwner);
    }
    public List<BusinessOwner> getAllBusinessOwners(){
        return businessOwnerDao.getAll();
    }
    public BusinessOwner searchBusinessOwner(String firstName, String lastName){
        return businessOwnerDao.search(firstName,lastName).orElseThrow(
                ()-> new NotFoundException("Business Owner Not Found")
        );
    }
}
