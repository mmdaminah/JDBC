package app.raiko.view.Admin.ShowAll;

import app.raiko.controller.admin.AdminController;
import app.raiko.model.admin.domain.Admin;
import app.raiko.view.Admin.ShowInfo.AdminShowInfo;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ShowAllAdmins {
   public static void show(AdminController adminController,Admin admin){

       var AllAdmins=adminController.getAll(admin);

       var streamOfAdmins=AllAdmins.stream();

       streamOfAdmins.forEach((admins -> AdminShowInfo.show(admins)));
    }
}
