package smartdrive;

import javax.security.auth.login.LoginException;

public class DriverAuthHandler {
  public static VehicleOwner login(String email, String password) throws LoginException{
    VehicleOwner vehicleOwner = TelemetrySource.getVehicleOwner(email);

    if(vehicleOwner == null){
      throw new LoginException("the email not found");
    }
    if(password.equals(vehicleOwner.getPassword())){
      vehicleOwner.setAuthenticated(true);
      return vehicleOwner;
    }
    else throw new LoginException("Innocorect password");
  }

  public static void logout(VehicleOwner vehicleOwner){
    vehicleOwner.setAuthenticated(false);
  }
}
