package app.raiko;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

  private static String databaseUrl = "jdbc:postgresql://localhost:5000/intern";
  private static String username = "admin";
  private static String password = "admin";

  public static Connection getConnection() {
    try {
      var connection = DriverManager.getConnection(databaseUrl, username, password);
      System.out.println("ارتباط با دیتابیس برقرار شد");
      return connection;
    } catch (SQLException e) {
      throw new RuntimeException("ارتباط با دیتابیس برقرار نشد");
    }
  }
}
