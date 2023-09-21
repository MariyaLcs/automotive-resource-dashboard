package smartdrive;

public class VehicleOwner {

  private int id;
  private String name;
  private String email;
  private String password;
  private int carId;
  private boolean authenticated;

  public boolean isAuthenticated() {
    return this.authenticated;
  }

  public void setAuthenticated(boolean authenticated) {
    this.authenticated = authenticated;
  }

  public VehicleOwner(int id, String name, String email, String password, int carId){
    setId(id);
    setName(name);
    setEmail(email);
    setPassword(password);
    setCarId(carId);
    setAuthenticated(false);
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getCarId() {
    return this.carId;
  }

  public void setCarId(int carId) {
    this.carId = carId;
  }

}
