package app.raiko.model.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDataSource implements DataSource<Connection> {

  private static String databaseUrl = "jdbc:postgresql://localhost:5432/jdbc_project_v2";
  private static String username = "postgres";
  private static String password = "13761376";

  public Connection connect() {
    try {
      var connection = DriverManager.getConnection(databaseUrl, username, password);
      return connection;
    } catch (SQLException e) {
      throw new RuntimeException("ارتباط با دیتابیس برقرار نشد");
    }
  }
}
