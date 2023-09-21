package smartdrive;

import smartdrive.exceptions.AmountException;

public class Car {
  
  private int id;
  private String type;
  private double fuelLevel;

  public Car(int id, String type, double fuelLevel){
    setId(id);
    setType(type);
    setFuelLevel(fuelLevel);
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public double getFuelLevel() {
    return this.fuelLevel;
  }

  public void setFuelLevel(double fuelLevel) {
    this.fuelLevel = fuelLevel;
  }

  public void refuelVehicle(double amount) throws AmountException{
    if(amount <1){
      throw new AmountException("Ensure a minimum of 1.00 units is allocated.");
    }
    else{
      double newFuelLevel = fuelLevel + amount;
      setFuelLevel(newFuelLevel);
    }
  }
  public void fuelConsumptionLevel(double amount){}
}
