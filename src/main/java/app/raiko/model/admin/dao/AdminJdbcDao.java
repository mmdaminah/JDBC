package app.raiko.model.admin.dao;

import app.raiko.exception.NotFoundAdminException;
import app.raiko.model.admin.domain.Admin;
import app.raiko.model.datasource.DataSource;
import lombok.AllArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class AdminJdbcDao implements AdminDao {
  private final DataSource dataSource;

  @Override
  public Optional<Admin> get(Integer id) {
    try (var connection = dataSource.getConnection()) {

      var selectSql = """ 
select * from admin where id = ? limit 1;
""";

      try (var statement = connection.prepareStatement(selectSql)) {

        statement.setInt(1, id);

        ResultSet foundAdmin = statement.executeQuery();

        if (foundAdmin.next()) {
          return Optional.of(
              new Admin(
                      foundAdmin.getInt("id"),
                      foundAdmin.getString("first_name"),
                      foundAdmin.getString("last_name"),
                      foundAdmin.getString("username"),
                      foundAdmin.getString("password"),
                      foundAdmin.getString("phone_number"),
                      foundAdmin.getInt("creator"),
                      foundAdmin.getBoolean("super_admin")));
        } else return Optional.empty();
      }

    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException("در اجرای پرس و جو از دیتابیس خطایی رخ داد!");
    }
  }













  @Override
  public List<Admin> getAll(Admin admin) {

    if (admin.getSuperAdmin()){

    try (var connection = dataSource.getConnection()) {

      var selectSql = """
          select * from admin ;
""";

      try (var statement = connection.prepareStatement(selectSql)) {


        ResultSet foundAdmin = statement.executeQuery();

        var AllAdmins=new ArrayList<Admin>();
        while (foundAdmin.next()) {
          AllAdmins.add(
                  new Admin(
                          foundAdmin.getInt("id"),
                          foundAdmin.getString("first_name"),
                          foundAdmin.getString("last_name"),
                          foundAdmin.getString("username"),
                          foundAdmin.getString("password"),
                          foundAdmin.getString("phone_number"),
                          foundAdmin.getInt("creator"),
                          foundAdmin.getBoolean("super_admin")));
        }
        return AllAdmins;
      }

    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException("something went wrong with the query");
    }
    }
    else throw new NotFoundAdminException("Only super admin can view this list");
  }



  @Override
  public boolean update(Integer id, Admin admin) {
    return false;
  }

  @Override



  public Optional<Admin> login(String username, String password) {
    try (var connection = dataSource.getConnection()) {

      var selectSql = """
          select * from admin where username = ? and password= ? ;
""";

      try (var statement = connection.prepareStatement(selectSql)) {

        statement.setString(1, username);
        statement.setString(2, password);


var resultset=statement.executeQuery();
        if ( resultset.next() ) {

          return Optional.of(
                  new Admin(
                          resultset.getInt("id"),
                          resultset.getString("first_name"),
                          resultset.getString("last_name"),
                          resultset.getString("username"),
                          resultset.getString("password"),
                          resultset.getString("phone_number"),
                          resultset.getInt("creator"),
                          resultset.getBoolean("super_admin")));
        } else return Optional.empty();
      }

    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException("در اجرای پرس و جو از دیتابیس خطایی رخ داد!");
    }

  }
  @Override
  public boolean delete(Integer id) {
    return false;
  }



  @Override
  public boolean findSuperAdmin(){
    try(var connection = dataSource.getConnection()){
      var query = "select * from admin where super_admin = true";
      try(var statement = connection.prepareStatement(query)){
        var result = statement.executeQuery();
        return result.next();
      }
    }
    catch (SQLException e){
      throw new RuntimeException(e);
    }
  }
  @Override
  public boolean create(Admin admin){
    try(var connection = dataSource.getConnection()){
      var query = """
                   insert into admin( first_name, last_name,
                                       username , password, 
                                       phone_number,creator, 
                                       super_admin)
                    values(?,?,?,?,?,?,?)                    
                    """;
      try(var statement = connection.prepareStatement(query)){
        statement.setString(1,admin.getFirstName());
        statement.setString(2,admin.getLastName());
        statement.setString(3,admin.getUsername());
        statement.setString(4,admin.getPassword());
        statement.setString(5,admin.getPhoneNumber());
        statement.setInt(6,admin.getCreator());
        statement.setBoolean(7,admin.getSuperAdmin());
        return statement.execute();
      }
    }
    catch (SQLException e){
      throw new RuntimeException(e);
    }
  }

  @Override
  public boolean createSuperAdmin(Admin admin){
    try(var connection = dataSource.getConnection()){
      var query = """
                   insert into admin( first_name, last_name,
                                       username , password, 
                                       phone_number, 
                                       super_admin)
                    values(?,?,?,?,?,?)                    
                    """;
      try(var statement = connection.prepareStatement(query)){
        statement.setString(1,admin.getFirstName());
        statement.setString(2,admin.getLastName());
        statement.setString(3,admin.getUsername());
        statement.setString(4,admin.getPassword());
        statement.setString(5,admin.getPhoneNumber());
        statement.setBoolean(6,admin.getSuperAdmin());
        return statement.execute();
      }
    }
    catch (SQLException e){
      throw new RuntimeException(e);
    }
  }
  public void updatePassword(Integer id, String password){
    try(var connection = dataSource.getConnection()){
      var query = "select * from admin where id = ?";
      try(var statement = connection.prepareStatement(query,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)){
        statement.setInt(1,id);
        var result = statement.executeQuery();
        result.next();
        result.updateString("password",password);
        result.updateRow();
      }
    }
    catch (SQLException e){
      throw new RuntimeException(e);
    }
  }
}


