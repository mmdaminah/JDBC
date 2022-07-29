package app.raiko.view.Menu;

import app.raiko.model.admin.domain.Admin;
import app.raiko.view.Admin.AdminChangePassword.AdminChangePassword;
import app.raiko.view.Admin.AdminShow.AdminShowInfo;
import app.raiko.view.Admin.AdminShow.ShowAllAdmins;
import app.raiko.view.Admin.CreateAdmin.CreateAdmin;
import app.raiko.view.Shop.ShopViewFactory;
import lombok.AllArgsConstructor;
import app.raiko.view.Business.IndexViewFactory;
import java.util.Scanner;

@AllArgsConstructor
public class AdminMenu {
    private AdminShowInfo adminShowInfo;
    private ShowAllAdmins showAllAdmins;
    private CreateAdmin createAdmin;
    private AdminChangePassword adminChangePassword;

    public void Loginmenu(Admin admin){
        var shopView = ShopViewFactory.create();
        System.out.println("""
                       
                               1)myInformations
                               2)List Of Admins
                               3)Create BusinessOwner
                               4)Create New Admin
                               5)Change Password
                               6)Get All Shops
                               7)Get Shop By ID
                               8)Update Shop By ID
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
            case 3 ->{
                IndexViewFactory.create(admin).createBusinessOwner();
                Loginmenu(admin);

            }
            case 4 ->{
                createAdmin.show(admin);Loginmenu(admin);
            }
            case 5 ->{
                adminChangePassword.show(admin);
            }
            case 6 -> shopView.getAllShops();
            case 7 -> shopView.getShop();
            case 8 -> shopView.updateShop();
        }
    }
}
