package app.raiko.view.Admin;

import app.raiko.controller.admin.AdminController;
import app.raiko.model.admin.domain.Admin;
import app.raiko.view.Admin.AdminChangePassword.AdminChangePassword;
import app.raiko.view.Admin.AdminFounderView.AdminFounderView;
import app.raiko.view.Login.AdminLogin.AdminLogin;
import app.raiko.view.Admin.ShowAll.ShowAllAdmins;
import app.raiko.view.Admin.CreateAdmin.CreateAdmin;
import app.raiko.view.Admin.ShowInfo.AdminShowInfo;
import app.raiko.view.Login.SuperAdmin.SuperAdmin;

public class AdminViewIndex {
    private AdminController adminController;
    private Admin connectedAdmin;
    public AdminViewIndex(AdminController adminController, Admin connectedAdmin) {
        this.adminController = adminController;
        this.connectedAdmin = connectedAdmin;
    }
    public void createAdmin(){
        CreateAdmin.create(adminController,connectedAdmin);
    }
    public void showAllAdmins(){
        ShowAllAdmins.show(adminController,connectedAdmin);
    }
    public void changeAdminPassword(){
        AdminChangePassword.change(adminController,connectedAdmin);
    }
    public void findAdmin(){
        AdminFounderView.show(adminController);
    }
    public void showAdminInfo(Admin admin){
        AdminShowInfo.show(admin);
    }
    public void adminLogin(){
        AdminLogin.show(adminController);
    }
}
