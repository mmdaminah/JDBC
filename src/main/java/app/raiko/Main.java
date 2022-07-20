package app.raiko;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
      var reader = new Scanner(System.in);

      System.out.println("enter first name : ");
      var firstName = reader.next();
      System.out.println("enter last name : ");
      var lastName = reader.next();
      System.out.println("enter username: ");
      var username = reader.next();
      System.out.println("enter password : ");
      var password = reader.next();
      System.out.println("enter address: ");
      var address = reader.next();
      System.out.println("enter national code : ");
      var nationalCode = reader.next();

    try (var connection = DataSource.getConnection();

    ) {

     var insertSql = """
             insert into admins (first_name, last_name, username, password, national_code, address)
                  values (?,?,?,?,?,?);
             """;

      var selectSql = """
              select * from admins;
              """;
      try(
              var selectStatement = connection.prepareStatement(selectSql);
              var insertStatement = connection.prepareStatement(insertSql, ResultSet.TYPE_SCROLL_SENSITIVE)
      ){

          insertStatement.setString(1,firstName);
          insertStatement.setString(2,lastName);
          insertStatement.setString(3,username);
          insertStatement.setString(4,password);
          insertStatement.setString(5,nationalCode);
          insertStatement.setString(6,address);

          connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
          connection.setAutoCommit(false);
          insertStatement.execute();
          connection.commit();

        var resultSet = selectStatement.executeQuery();

        while (resultSet.next()){
          var id = resultSet.getInt(1);
          var firstNameColumn= resultSet.getString(2);
          var lastNameColumn = resultSet.getString(3);
          var usernameColumn = resultSet.getString(4);

          System.out.println("%d %s %s %s".formatted(id,firstNameColumn,lastNameColumn,usernameColumn));
        }
        }



    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
