package app.raiko.view.Shop.Search;

import app.raiko.controller.shop.ShopController;
import app.raiko.exception.NotFoundException;

import java.util.Scanner;

public class GetShop {
    public static void get(ShopController shopController){
        var reader = new Scanner(System.in);
        System.out.println("Please Insert Shop Id : ");
        var id = reader.nextInt();
        try {
            var shop = shopController.getShop(id);
            System.out.printf("""
                id : %d
                name : %s
                description : %s
                postal_address : %s
                location_address : %s
            """, shop.getId(),shop.getName(),shop.getDescription(),
                shop.getPostalAddress(),shop.getLocationAddress());
        }
        catch (NotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
