package smartdrive;

import java.util.Scanner;

import javax.security.auth.login.LoginException;

public class DriverConsole {

  private Scanner scanner;

  public static void main(String[] args) {
    System.out.println("Welcome on board 🏁");

    DriverConsole driverConsole = new DriverConsole();
    driverConsole.scanner = new Scanner(System.in);
    VehicleOwner vehicleOwner = driverConsole.driverAuthentication();
    if (vehicleOwner != null) {
      Car car = TelemetrySource.getCar(vehicleOwner.getAccountId());
      driverConsole.showControlPanel(vehicleOwner, car);
    }

    driverConsole.scanner.close();
  }

  private VehicleOwner driverAuthentication() {
    System.out.println("Please enter your email");
    String email = scanner.next();

    System.out.println("Please enter your password");
    String password = scanner.next();

    VehicleOwner vehicleOwner = null;
    try {
      vehicleOwner = DriverAuthHandler.login(email, password);
    } catch (LoginException e) {
      System.out.println("Lost connection with the cloud" + e.getMessage());
    }

    return vehicleOwner;
  }

  private void showControlPanel(VehicleOwner vehicleOwner, Car car) {
    int selection = 0;

    while (selection != 4 && vehicleOwner.isAuthenticated()) {
      System.out.println("==============");
      System.out.println("Please select one of the following options: ");
      System.out.println("1: Refuel Vehicle ⛽︎");
      System.out.println("2: Fuel Consumption ⚡️");
      System.out.println("3: Fuel Level 🎚️");
      System.out.println("4: Exit");
      System.out.println("==============");

      selection = scanner.nextInt();
      double amount = 0;

      switch (selection) {
        case 1:
          System.out.println("How much is added to the fuel tank?");
          amount = scanner.nextDouble();
          car.refuelVehicle(amount);
          break;

        case 2:
          System.out.println("Set your preferred fuel consumption");
          amount = scanner.nextDouble();
          car.fuelConsumptionLevel(amount);
          break;

        case 3:
          System.out.println("Current Fuel Level: " + car.getFuelLevel());
          break;

        case 4:
          DriverAuthHandler.logout(vehicleOwner);
          System.out.println("Local time 🕗");
          break;
        
        default:
          System.out.println("Please try again");
          break;
      }
    }
  }
}
