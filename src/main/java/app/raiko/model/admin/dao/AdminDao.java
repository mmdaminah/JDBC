package app.raiko.model.admin.dao;

import app.raiko.model.admin.domain.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminDao {
  Optional<Admin> get(Integer id);

  List<Admin> getAll();

  boolean update(Integer id, Admin admin);
  Optional<Admin> login(String userName, String password);

  boolean delete(Integer id);

  boolean create(Admin admin);
}
