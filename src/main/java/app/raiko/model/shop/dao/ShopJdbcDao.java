package app.raiko.model.shop.dao;

import app.raiko.model.shop.domain.Shop;
import app.raiko.model.datasource.JdbcDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShopJdbcDao implements ShopDao {
    private final JdbcDataSource dataSource;

    public ShopJdbcDao(JdbcDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void updateShop(Shop shop){
        try(var connection = new JdbcDataSource().connection()){
            var query = "select * from shop where id = ?";
            try(var statement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE)){
                statement.setInt(1,shop.getId());
                var result = statement.executeQuery();
                result.next();
                result.updateString("name",shop.getName());
                result.updateString("description",shop.getDescription());
                result.updateString("postal_address",shop.getPostalAddress());
                result.updateString("location_address",shop.getLocationAddress());
                result.updateRow();
            }
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Shop> getAllShops() {
        try(var connection = dataSource.connection()){
            var query = "select * from shop";
            try(var statement = connection.prepareStatement(query)){
                var shops = new ArrayList<Shop>();
                var result = statement.executeQuery();
                while(result.next()){
                    var id = result.getInt("id");
                    var name = result.getString("name");
                    var description = result.getString("description");
                    var postalAddress = result.getString("postal_address");
                    var locationAddress= result.getString("location_address");
                    var creator = result.getInt("creator");
                    var owner = result.getInt("owner");
                    shops.add(
                            new Shop(
                                    id,name,
                                    description,postalAddress,
                                    locationAddress,creator,
                                    owner
                            )
                    );
                }
                return shops;
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Shop> getShop(Integer id) {
        try (var connection = dataSource.connection()) {
            var query = "select * from shop where id = ?";
            try (var statement = connection.prepareStatement(query)) {

                statement.setInt(1, id);

                ResultSet foundShop = statement.executeQuery();

                if (foundShop.next()) {
                    return Optional.of(
                            new Shop(
                                    foundShop.getInt("id"),
                                    foundShop.getString("name"),
                                    foundShop.getString("description"),
                                    foundShop.getString("postal_address"),
                                    foundShop.getString("location_address"),
                                    foundShop.getInt("creator"),
                                    foundShop.getInt("owner")
                            ));
                } else return Optional.empty();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error Occurred in Running Query");
        }
    }

}
