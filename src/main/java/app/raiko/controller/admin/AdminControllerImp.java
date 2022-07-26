package app.raiko.controller.admin;

import app.raiko.exception.NotFoundAdminException;
import app.raiko.model.admin.dao.AdminDao;
import app.raiko.model.admin.domain.Admin;
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

  @Override
  public boolean LoginAdmin(String userName, String password) {
    return adminDao.login(userName,password);
  }
}
