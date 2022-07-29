package app.raiko.controller.shop;
import app.raiko.exception.NotFoundException;
import app.raiko.model.Shop.dao.ShopJdbcDao;
import app.raiko.model.Shop.domain.Shop;

import java.util.List;

public class ShopControllerImp implements ShopController {
    private final ShopJdbcDao shopJdbcDao;

    public ShopControllerImp(ShopJdbcDao shopJdbcDao) {
        this.shopJdbcDao = shopJdbcDao;
    }

    @Override
    public void updateShop(Shop shop) {
        shopJdbcDao.updateShop(shop);
    }

    @Override
    public Shop getShop(Integer id) {
        return shopJdbcDao.getShop(id).orElseThrow(()-> new NotFoundException("Shop Not Found!"));
    }

    @Override
    public List<Shop> getAllShops() {
        return shopJdbcDao.getAllShops();
    }
}
