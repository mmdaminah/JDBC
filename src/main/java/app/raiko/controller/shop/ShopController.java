package app.raiko.controller.shop;

import app.raiko.model.Shop.domain.Shop;

import java.util.List;

public interface ShopController {
    void updateShop(Shop shop);
    Shop getShop(Integer id);
    List<Shop> getAllShops();
}
