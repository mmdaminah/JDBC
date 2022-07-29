package app.raiko.view.Admin.CreateAdmin;

import app.raiko.controller.admin.AdminController;
import app.raiko.model.admin.domain.Admin;

import java.util.Scanner;

public class CreateAdmin {
    private AdminController adminController;

    public CreateAdmin(AdminController adminController) {
        this.adminController = adminController;
    }

    public void show(Admin admin){
        if(admin.getSuperAdmin()){
        var reader = new Scanner(System.in);
        System.out.println("Please insert first name : ");
        var firstName = reader.next();
        System.out.println("Please insert last name : ");
        var lastName = reader.next();
        System.out.println("Please insert username : ");
        var username = reader.next();
        System.out.println("Please insert password : ");
        var password = reader.next();
        System.out.println("Please insert phone number : ");
        var phoneNumber = reader.next();
        try{
        adminController.createAdmin(
                new Admin(
                        null,
                        firstName,lastName,
                        username,password,
                        phoneNumber,admin.getId(),
                        false
                )
        );
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        }
        else {
            System.out.println("Only Super Admin Can Create Admin");
        }
    }
}
