package app.raiko.controller.admin;

import app.raiko.exception.NotFoundAdminException;
import app.raiko.model.admin.dao.AdminDao;
import app.raiko.model.admin.domain.Admin;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class AdminControllerImp implements AdminController {
  private AdminDao adminDao;

  @Override
  public Admin findAdmin(Integer id) {
    return adminDao
        .get(id)
        .orElseThrow(
            () -> new NotFoundAdminException("not found any admin with id : %s".formatted(id)));
  }

  @Override
  public Admin LoginAdmin(String userName, String password) {
    return adminDao.login(userName,password).orElseThrow(()->new NotFoundAdminException("Admin not found"));
  }

  @Override
  public List<Admin> getAll(Admin admin) {
    return adminDao.getAll(admin);
  }
  public boolean findSuperAdmin(){
    return adminDao.findSuperAdmin();
  }
  public boolean createAdmin(Admin admin){
    return adminDao.create(admin);
  }
  public boolean createSuperAdmin(Admin admin){
    return adminDao.createSuperAdmin(admin);
  }

  @Override
  public void updatePassword(Integer id, String password) {
    adminDao.updatePassword(id,password);
  }
}
