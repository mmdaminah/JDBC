package app.raiko.controller.admin;

import app.raiko.exception.NotFoundException;
import app.raiko.model.admin.dao.AdminDao;
import app.raiko.model.admin.domain.Admin;
import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class AdminControllerImp implements AdminController {
  private AdminDao adminDao;

  @Override
  public Admin findAdmin(Integer id) {
    return adminDao
        .get(id)
        .orElseThrow(
            () -> new NotFoundException("not found any admin with id : %s".formatted(id)));
  }

  @Override
  public Admin LoginAdmin(String username, String password) {
    var userExists = adminDao.usernameExits(username);
    if(userExists){
      var admin = adminDao.getAdminByUsername(username);
      if(checkPassword(password,admin.getPassword())){
        return admin;
      }
      else{
        throw new NotFoundException("Password is wrong!");
      }
    }
    else {
      throw new NotFoundException("Admin not found!");
    }
  }

  @Override
  public List<Admin> getAll(Admin admin) {
    if(admin.getSuperAdmin())
      return adminDao.getAll(admin);
    else return new ArrayList<Admin>();
  }
  public boolean findSuperAdmin(){
    return adminDao.findSuperAdmin();
  }
  public boolean createAdmin(Admin admin){
    var hashedPassword = encryptPassword(admin.getPassword());
    admin.setPassword(hashedPassword);
    return adminDao.create(admin);
  }
  public boolean createSuperAdmin(Admin admin){
    var hashedPassword = encryptPassword(admin.getPassword());
    admin.setPassword(hashedPassword);
    return adminDao.createSuperAdmin(admin);
  }

  @Override
  public void updatePassword(Integer id, String oldPassword,String currentPassword,String newPassword) {
    var oldPass = encryptPassword(oldPassword);
    if(checkPassword(oldPass,currentPassword)){
      adminDao.updatePassword(id,encryptPassword(newPassword));
    }
    else{
      throw new RuntimeException("Passwords doen't match");
    }
  }
  @Override
  public boolean checkPassword(String pass1, String pass2){
    return BCrypt.checkpw(pass1, pass2);
  }
  @Override
  public String encryptPassword(String password){
    var hashSalt = "$2a$12$apzCcIJzGisgrHBhBS9DKu";
    return BCrypt.hashpw(password,hashSalt);
  }
}
