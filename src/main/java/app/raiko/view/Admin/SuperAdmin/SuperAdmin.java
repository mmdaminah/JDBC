package app.raiko.view.Admin.SuperAdmin;

import app.raiko.controller.admin.AdminController;
import app.raiko.model.admin.domain.Admin;

import java.util.Scanner;

public class SuperAdmin {

    private AdminController adminController;

    public SuperAdmin(AdminController adminController) {
        this.adminController = adminController;
    }

    public void show(){
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
            adminController.createSuperAdmin(
                    new Admin(
                            null,
                            firstName,lastName,
                            username,password,
                            phoneNumber,0,
                            true
                    )
            );
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
    public boolean getSuperAdmin(){
        return adminController.findSuperAdmin();
    }
}
