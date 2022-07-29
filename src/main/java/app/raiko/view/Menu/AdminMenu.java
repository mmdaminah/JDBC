package app.raiko.view.Menu;

import app.raiko.model.admin.domain.Admin;
import app.raiko.view.Admin.AdminViewFactory;
import app.raiko.view.Shop.ShopViewFactory;
import lombok.AllArgsConstructor;
import app.raiko.view.Business.BusinessViewFactory;
import java.util.Scanner;

@AllArgsConstructor
public class AdminMenu {
       public static void MainMenu(Admin admin){
        var adminView = AdminViewFactory.create(admin);
        var businessView = BusinessViewFactory.create(admin);
        var shopView = ShopViewFactory.create();
        while(true){
            System.out.println("""
                                   1)Get My Informations
                                   2)List Of Admins
                                   3)Create BusinessOwner
                                   4)Create New Admin
                                   5)Change Password
                                   6)Get All Shops
                                   7)Get Shop By ID
                                   8)Update Shop By ID
                                   9)Edit BusinessOwner
                                   10)Exit
                                   """);
            System.out.println("your action : ");
            var operator = new Scanner(System.in).nextInt();
            switch (operator){
                case 1 -> adminView.showAdminInfo(admin);
                case 2 -> adminView.showAllAdmins();
                case 3 -> businessView.createBusinessOwner();
                case 4 -> adminView.createAdmin();
                case 5 -> adminView.changeAdminPassword();
                case 6 -> shopView.getAllShops();
                case 7 -> shopView.getShop();
                case 8 -> shopView.updateShop();
                case 9 -> businessView.updateBusinessOwner();
                case 10 -> System.exit(0);
            }

        }
    }
}
