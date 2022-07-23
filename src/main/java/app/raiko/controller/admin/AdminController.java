package app.raiko.controller.admin;

import app.raiko.model.admin.domain.Admin;

public interface AdminController {
  Admin findAdmin(Integer id);
}
