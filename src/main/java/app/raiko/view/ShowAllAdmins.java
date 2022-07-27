package app.raiko.view;

import app.raiko.controller.admin.AdminController;
import app.raiko.model.admin.domain.Admin;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@AllArgsConstructor
public class ShowAllAdmins {
    AdminController adminController;


    void show(Admin admin){

       var AllAdmins=adminController.getAll(admin);

       var streamOfAdmins=AllAdmins.stream();

       streamOfAdmins.forEach((admins -> AdminShowInfo.ShowInfo(admins)));
    }
}
