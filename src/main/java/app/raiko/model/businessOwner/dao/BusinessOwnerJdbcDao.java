package app.raiko.model.businessOwner.dao;

import app.raiko.model.admin.domain.Admin;
import app.raiko.model.businessOwner.domain.BusinessOwner;
import app.raiko.model.datasource.DataSource;
import lombok.AllArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class BusinessOwnerJdbcDao implements BusinessOwnerDao{
    private final DataSource dataSource;


    @Override
    public boolean create_businessOwner(Admin admin, BusinessOwner businessOwner) {
        try(var connection = dataSource.getConnection()){
            var query = """
                   insert into business_owner( first_name, last_name,
                                        national_code,
                                       phone_number,
                                       creator)
                    values(?,?,?,?,?)                    
                    """;
            try(var statement = connection.prepareStatement(query)){
                statement.setString(1,businessOwner.getFirstName());
                statement.setString(2,businessOwner.getLastName());
                statement.setString(3,businessOwner.getNationalCode());
                statement.setString(4,businessOwner.getPhoneNumber());
                statement.setInt(5,businessOwner.getCreator());
                return statement.execute();
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public List<BusinessOwner> getAll(){
        try(var connection = dataSource.getConnection()){
            var query = "select * from business_owner";
            try(var statement = connection.prepareStatement(query)){
                var businessOwners = new ArrayList<BusinessOwner>();
                var result = statement.executeQuery();
                while(result.next()){
                    var id = result.getInt("id");
                    var firstName = result.getString("first_name");
                    var lastName = result.getString("last_name");
                    var nationalCode = result.getString("national_code");
                    var phoneNumber= result.getString("phone_number");
                    var creator = result.getInt("creator");
                    businessOwners.add(
                            new BusinessOwner(
                                    id,firstName,
                                    lastName,nationalCode,
                                    phoneNumber,creator
                            )
                    );
                }
                return businessOwners;
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<BusinessOwner> search(String firstName, String lastName) {
        try (var connection = dataSource.getConnection()) {
            var query = """
            select * from business_owner
            where first_name = ? and last_name = ?
            """;
            try (var statement = connection.prepareStatement(query)) {

                statement.setString(1, firstName);
                statement.setString(2, lastName);

                ResultSet foundBusinessOwner = statement.executeQuery();

                if (foundBusinessOwner.next()) {
                    return Optional.of(
                            new BusinessOwner(
                            foundBusinessOwner.getInt("id"),
                            foundBusinessOwner.getString("first_name"),
                            foundBusinessOwner.getString("last_name"),
                            foundBusinessOwner.getString("national_code"),
                            foundBusinessOwner.getString("phone_number"),
                            foundBusinessOwner.getInt("creator")
                            ));
                } else return Optional.empty();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error Occurred in Running Query");
        }
    }

    @Override
    public boolean delete(Integer id) {
        try(var connection = new DataSource().getConnection()){
            var query = "delete from business_owner where id = ?";
            try(var statement = connection.prepareStatement(query)){
                statement.setInt(1,id);
                return statement.execute();
            }
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    @Override
    public boolean edit_businessOwner(Integer id, BusinessOwner businessOwner) {
        try(var connection = dataSource.getConnection()){
            var query = "select * from business_owner where id = ?";
            try(var statement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)){
                statement.setInt(1,id);
                var result = statement.executeQuery();
                result.next();
                result.updateString("first_name",businessOwner.getFirstName());
                result.updateString("last_name", businessOwner.getLastName());
                result.updateString("national_code", businessOwner.getNationalCode());
                result.updateString("phone_number", businessOwner.getPhoneNumber());
                result.updateRow();
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
        return true;
    }
}
