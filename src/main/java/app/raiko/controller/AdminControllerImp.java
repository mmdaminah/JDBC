package app.raiko.controller;

import app.raiko.exception.NotFoundAdminException;
import app.raiko.model.dao.AdminDao;
import app.raiko.model.domain.Admin;
import lombok.AllArgsConstructor;

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
}
