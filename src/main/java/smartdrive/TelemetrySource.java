package smartdrive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TelemetrySource {
  

  public static Connection connect(){
    String db_file = "jdbc:sqlite:resources/customers.db";
    Connection connection = null;
    
    try{
      connection = DriverManager.getConnection(db_file); 
      System.out.println("connection successful");
    } catch(SQLException e){
      e.printStackTrace();
    }
    return connection;
    
  }
  public static void main(String[] args){
    connect();
  }
}
