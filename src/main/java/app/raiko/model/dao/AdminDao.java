package app.raiko.model.dao;

import app.raiko.model.domain.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminDao {
  Optional<Admin> get(Integer id);

  List<Admin> getAll();

  boolean update(Integer id, Admin admin);

  boolean delete(Integer id);

  boolean create(Admin admin);
}
