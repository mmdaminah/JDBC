package app.raiko.controller.admin;

import app.raiko.model.admin.domain.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminController {
  Admin findAdmin(Integer id);
   Admin LoginAdmin(String userName, String password);
    boolean findSuperAdmin();
    boolean createAdmin(Admin admin);
   List<Admin> getAll(Admin admin);
   boolean createSuperAdmin(Admin admin);
   void updatePassword(Integer id, String oldPassword,String currentPassword,String newPassword);
   boolean checkPassword(String pass1,String pass2);
   String encryptPassword(String password);
}
