package app.raiko.model.shop.dao;

import app.raiko.model.shop.domain.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopDao {
    void updateShop(Shop shop);
    List<Shop> getAllShops();
    Optional<Shop> getShop(Integer id);
}

