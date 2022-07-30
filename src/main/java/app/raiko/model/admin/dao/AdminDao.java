package app.raiko.model.admin.dao;

import app.raiko.model.admin.domain.Admin;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public interface AdminDao {
  Optional<Admin> get(Integer id);
  List<Admin> getAll(Admin admin);
  boolean update(Integer id, Admin admin);
  Optional<Admin> login(String userName, String password);
  boolean delete(Integer id);
  boolean create(Admin admin);
  boolean findSuperAdmin();
  boolean createSuperAdmin(Admin admin);
  void updatePassword(Integer id, String password);
  boolean usernameExits(String username);
  Admin getAdminByUsername(String username);
  Admin getCreator(Admin admin,Integer creator);
}
