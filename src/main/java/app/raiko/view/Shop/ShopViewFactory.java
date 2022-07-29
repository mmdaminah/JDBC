package app.raiko.view.Shop;

import app.raiko.controller.shop.ShopControllerImp;
import app.raiko.model.Shop.dao.ShopJdbcDao;
import app.raiko.model.datasource.DataSource;

public class ShopViewFactory {
    public static ShopViewIndex create(){
        var dataSource = new DataSource();
        var shopDao = new ShopJdbcDao(dataSource);
        var shopController = new ShopControllerImp(shopDao);
        return new ShopViewIndex(shopController);
    }
}
