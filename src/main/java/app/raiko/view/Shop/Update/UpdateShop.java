package app.raiko.view.Shop.Update;

import app.raiko.controller.shop.ShopController;
import app.raiko.exception.NotFoundException;
import app.raiko.model.Shop.domain.Shop;
import app.raiko.view.Shop.ShopViewFactory;
import app.raiko.view.Shop.ShopViewIndex;

import java.util.Scanner;

public class UpdateShop {
    public static void update(ShopController shopController){
        var reader = new Scanner(System.in);
        System.out.println("Please Insert Shop ID : ");
        var id = reader.nextInt();
        try{
            var shop = shopController.getShop(id);
            System.out.printf("name is : %s%nnew name : ",shop.getName());
            var name = reader.next();
            System.out.printf("description is : %s%nnew description : ",shop.getDescription());
            var description = reader.next();
            System.out.printf("postal address is : %s%nnew postal address : ",shop.getPostalAddress());
            var postalAddress = reader.next();
            System.out.printf("location address is : %s%nnew location address : ",shop.getLocationAddress());
            var locationAddress = reader.next();
            shopController.updateShop(
                    new Shop(
                            shop.getId(),
                            name,description,postalAddress,
                            locationAddress,shop.getCreator(),
                            shop.getOwner()
                    )
            );
        }
        catch (NotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
