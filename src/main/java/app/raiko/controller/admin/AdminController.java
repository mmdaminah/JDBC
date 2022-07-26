package app.raiko.controller.admin;

import app.raiko.model.admin.domain.Admin;

import java.util.Optional;

public interface AdminController {
  Admin findAdmin(Integer id);
   Admin LoginAdmin(String userName, String password);
}
