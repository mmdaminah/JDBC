package app.raiko.view.Shop;

import app.raiko.controller.shop.ShopControllerImp;
import app.raiko.model.shop.dao.ShopJdbcDao;
import app.raiko.model.datasource.JdbcDataSource;

public class ShopViewFactory {
    public static ShopViewIndex create(){
        var dataSource = new JdbcDataSource();
        var shopDao = new ShopJdbcDao(dataSource);
        var shopController = new ShopControllerImp(shopDao);
        return new ShopViewIndex(shopController);
    }
}
