package app.raiko.view.Shop.GetAll;

import app.raiko.controller.shop.ShopController;

public class GetAllShops {
    public static void getAll(ShopController shopController){
        var shops = shopController.getAllShops();
        shops.forEach(shop ->{
            System.out.printf("""
                id : %d
                name : %s
                description : %s
                postal_address : %s
                location_address : %s
            """, shop.getId(),shop.getName(),shop.getDescription(),
                    shop.getPostalAddress(),shop.getLocationAddress());
        });
    }
}
