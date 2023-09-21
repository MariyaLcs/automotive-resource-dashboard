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

  public static VehicleOwner getVehicleOwner(String email) {
    String sql = "select * from customers where email = ?";
    VehicleOwner vehicleOwner = null;
    try (Connection connection = connect();
        PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setString(1, email);
      try (ResultSet resultSet = statement.executeQuery()) {
        vehicleOwner = new VehicleOwner(
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getString("email"),
            resultSet.getString("password"),
            resultSet.getInt("account_id"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return vehicleOwner;
  }

  public static Car getCar(int accountId){
    String sql = "select * from cars where id = ?";
    Car car = null;
    try (Connection connection = connect();
        PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setInt(1, accountId);
      try (ResultSet resultSet = statement.executeQuery()) {
        car = new Car(
            resultSet.getInt("id"),
            resultSet.getString("type"),
            resultSet.getDouble("fuelLevel"));
            
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return car;
  }

  public static void main(String[] args) {
    VehicleOwner vehicleOwner1 = getVehicleOwner("twest8o@friendfeed.com");
    System.out.println(vehicleOwner1.getEmail());

    Car car1 = getCar(10385);
    System.out.println(car1.getFuelLevel());
  }
}
