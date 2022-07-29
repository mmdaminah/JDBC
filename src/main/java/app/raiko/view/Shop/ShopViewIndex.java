package app.raiko.view.Shop;

import app.raiko.controller.shop.ShopController;
import app.raiko.view.Shop.GetAll.GetAllShops;
import app.raiko.view.Shop.Search.GetShop;
import app.raiko.view.Shop.Update.UpdateShop;

public class ShopViewIndex {
    ShopController shopController;

    public ShopViewIndex(ShopController shopController) {
        this.shopController = shopController;
    }
    public void updateShop(){
        UpdateShop.update(shopController);
    }
    public void getAllShops(){
        GetAllShops.getAll(shopController);
    }
    public void getShop(){
        GetShop.get(shopController);
    }
}
