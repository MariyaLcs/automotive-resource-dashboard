package smartdrive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TelemetrySource {

  public static Connection connect() {
    String db_file = "jdbc:sqlite:resources/customers.db";
    Connection connection = null;

    try {
      connection = DriverManager.getConnection(db_file);
      System.out.println("connection successful");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return connection;
  }

  public static VehicleOwner getVehicleOwner(String username) {
    String sql = "select * from customers where username = ?";
    VehicleOwner vehicleOwner = null;
    try (Connection connection = connect();
        PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setString(1, username);
      try (ResultSet resultSet = statement.executeQuery()) {
        vehicleOwner = new VehicleOwner(
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getString("username"),
            resultSet.getString("password"),
            resultSet.getInt("account_id"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return vehicleOwner;
  }

  public static void main(String[] args) {
    VehicleOwner vehicleOwner1 = getVehicleOwner("twest8o@friendfeed.com");
    System.out.println(vehicleOwner1.getName());
  }
}
