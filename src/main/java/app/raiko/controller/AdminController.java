package app.raiko.controller;

import app.raiko.model.domain.Admin;

public interface AdminController {
  Admin findAdmin(Integer id);
}
