package app.raiko.view.Admin.AdminChangePassword;

import app.raiko.controller.admin.AdminController;
import app.raiko.model.admin.domain.Admin;

import java.util.Scanner;

public class AdminChangePassword {
    public static void change(AdminController adminController,Admin admin){
        System.out.println("Please Enter your old password");
        var reader = new Scanner(System.in);
        var oldPassword = reader.next();
        System.out.println("Please enter new Password : ");
        var newPassword1 = reader.next();
        System.out.println("Please Enter Your New Password Again : ");
        var newPassword2 = reader.next();
        if(newPassword1.equals(newPassword2)){
            adminController.updatePassword(admin.getId(),oldPassword,admin.getPassword(),newPassword1);
        }
        else{
            System.out.println("Password Doesn't Match");
        }
    }
}
