package app.raiko.view.Login.SuperAdmin;

import app.raiko.controller.admin.AdminController;
import app.raiko.model.admin.domain.Admin;

import java.util.Scanner;

public class SuperAdmin {
    public static void create(AdminController adminController){
        System.out.printf("No Super User Found!%nCreating one :%n");
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
                            phoneNumber,null,
                            true
                    )
            );
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
    public static boolean get(AdminController adminController){
        return adminController.findSuperAdmin();
    }
}
