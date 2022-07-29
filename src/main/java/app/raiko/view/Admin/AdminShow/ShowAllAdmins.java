package app.raiko.view.Admin.AdminShow;

import app.raiko.controller.admin.AdminController;
import app.raiko.model.admin.domain.Admin;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ShowAllAdmins {
    AdminController adminController;


   public void show(Admin admin){

       var AllAdmins=adminController.getAll(admin);

       var streamOfAdmins=AllAdmins.stream();

       streamOfAdmins.forEach((admins -> AdminShowInfo.ShowInfo(admins)));
    }
}
