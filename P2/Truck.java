public class Truck extends Vehicle {
  public Truck(String reg, String mfg, String own) { super(reg, mfg, own); }

  @Override
  public void checkPollutionStatus() {
    if (co2 <= 25 && co <= 0.8 && hc <= 1000)
      pollutionStatus = "PASS";
    else
      pollutionStatus = "FAIL";
  }
}
