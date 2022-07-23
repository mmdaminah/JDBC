package app.raiko.model.dao;

import app.raiko.model.datasource.DataSource;
import app.raiko.model.domain.Admin;
import lombok.AllArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class AdminJdbcDao implements AdminDao {
  private final DataSource dataSource;

  @Override
  public Optional<Admin> get(Integer id) {
    try (var connection = dataSource.getConnection()) {

      var selectSql = "select * from Admins where id = ? limit 1;";

      try (var statement = connection.prepareStatement(selectSql)) {

        statement.setInt(1, id);

        ResultSet foundAdmin = statement.executeQuery();

        if (foundAdmin.next()) {
          return Optional.of(
              new Admin(
                  id,
                  foundAdmin.getString("first_name"),
                  foundAdmin.getString("last_name"),
                  foundAdmin.getString("username"),
                  foundAdmin.getString("password")));
        } else return Optional.empty();
      }

    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException("در اجرای پرس و جو از دیتابیس خطایی رخ داد!");
    }
  }

  @Override
  public List<Admin> getAll() {
    return null;
  }

  @Override
  public boolean update(Integer id, Admin admin) {
    return false;
  }

  @Override
  public boolean delete(Integer id) {
    return false;
  }

  @Override
  public boolean create(Admin admin) {
    return false;
  }
}
