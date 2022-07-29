package app.raiko.view.Login;

import app.raiko.controller.admin.AdminController;
import app.raiko.model.admin.domain.Admin;
import app.raiko.view.Login.AdminLogin.AdminLogin;
import app.raiko.view.Login.SuperAdmin.SuperAdmin;

import java.util.Optional;

public class LoginViewIndex {
    AdminController adminController;

    public LoginViewIndex(AdminController adminController) {
        this.adminController = adminController;
    }
    public Optional<Admin> login(){
        return AdminLogin.show(adminController);
    }
    public void createSuperAdmin(){
        SuperAdmin.create(adminController);
    }

    public boolean isSuperAdminAvailable(){
        return SuperAdmin.get(adminController);
    }
}

