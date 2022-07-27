package app.raiko.view.Menu;

import app.raiko.model.admin.domain.Admin;
import app.raiko.view.AdminChangePassword.AdminChangePassword;
import app.raiko.view.AdminShow.AdminShowInfo;
import app.raiko.view.AdminShow.ShowAllAdmins;
import app.raiko.view.CreateAdmin.CreateAdmin;
import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class AdminMenu {
    private AdminShowInfo adminShowInfo;
    private ShowAllAdmins showAllAdmins;
    private CreateAdmin createAdmin;
    private AdminChangePassword adminChangePassword;

    public void Loginmenu(Admin admin){
        System.out.println("""
                       
                               1)myInformations
                               2)List Of Admins
                               4)Create New Admin
                               5)Change Password
                               """);


        System.out.println("your action : ");
        var operator = new Scanner(System.in).nextInt();

        switch (operator){

            case 1 -> {
                adminShowInfo.ShowInfo(admin); Loginmenu(admin);
            }
            case 2 -> {
                showAllAdmins.show(admin); Loginmenu(admin);
            }
            case 4 ->{
                createAdmin.show(admin);Loginmenu(admin);
            }
            case 5 ->{
                adminChangePassword.show(admin);
            }
        }
    }
}
