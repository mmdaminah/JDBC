package app.raiko.view;

import app.raiko.model.admin.domain.Admin;
import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class AdminMenu {
    private AdminShowInfo adminShowInfo;
    private ShowAllAdmins showAllAdmins;


    void Loginmenu(Admin admin){
        System.out.println("""
                       
                               1)myInformations
                               2)List Of Admins
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
        }
    }
}
