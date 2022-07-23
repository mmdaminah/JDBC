package app.raiko.controller;

import app.raiko.model.domain.Admin;

public interface AdminService {
  Admin findAdmin(Integer id);
}
