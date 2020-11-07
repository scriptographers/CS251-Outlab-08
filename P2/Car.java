public class Car extends Vehicle {
  public Car(String reg, String mfg, String own) { super(reg, mfg, own); }

  @Override
  public void checkPollutionStatus() {
    if (co2 <= 15 && co <= 0.5 && hc <= 750)
      pollutionStatus = "PASS";
    else
      pollutionStatus = "FAIL";
  }
}
