public class Vehicle {

  // Attributes
  private String regNo;             // vehicle registration number
  private String manufacturer;      // manufacturer name
  private String owner;             // name of the owner
  protected double co2;             // CO2 emission level
  protected double co;              // CO emission level
  protected double hc;              // HC emission level
  protected String pollutionStatus; // Can be PASS, FAIL, PENDING

  // Functions
  public Vehicle(String reg, String mfg, String own) {
    regNo = reg;
    manufacturer = mfg;
    owner = own;
    pollutionStatus = "PENDING";
  }

  public void checkPollutionStatus() { return; }

  public String toString() {
    return String.format(
        "Reg No: %s\nManufacturer: %s\n Owner: %s\n Pollution Status: %s\n",
        regNo, manufacturer, owner, pollutionStatus);
  }

  // Extra functions: Setters and Getters
  public void setPollutants(double co2, double co, double hc) {
    this.co2 = co2;
    this.co = co;
    this.hc = hc;
    checkPollutionStatus();
  }

  public String getPollutionStatus() { return pollutionStatus; }
}
