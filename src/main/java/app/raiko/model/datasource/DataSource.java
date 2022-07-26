package app.raiko.model.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

  private static String databaseUrl = "jdbc:postgresql://localhost:5432/jdbc_project_v2";
  private static String username = "postgres";
  private static String password = "22552255";

  public Connection getConnection() {
    try {
      var connection = DriverManager.getConnection(databaseUrl, username, password);
      System.out.println("ارتباط با دیتابیس برقرار شد");
      return connection;
    } catch (SQLException e) {
      throw new RuntimeException("ارتباط با دیتابیس برقرار نشد");
    }
  }
}
