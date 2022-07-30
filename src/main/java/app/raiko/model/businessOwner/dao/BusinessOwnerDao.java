package app.raiko.model.businessOwner.dao;

import app.raiko.model.admin.domain.Admin;
import app.raiko.model.businessOwner.domain.BusinessOwner;

import java.util.List;
import java.util.Optional;

public interface BusinessOwnerDao {

    boolean createBusinessOwner(Admin admin, BusinessOwner businessOwner);
    List<BusinessOwner> getAll();
    Optional<BusinessOwner> search(String firstName, String lastName);
    boolean delete(Integer id);
    boolean editBusinessOwner(Integer id, BusinessOwner businessOwner);

}
