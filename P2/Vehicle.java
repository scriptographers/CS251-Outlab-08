public class Vehicle {

  // Attributes
  private String regNo;           // vehicle registration number
  private String manufacturer;    // manufacturer name
  private String owner;           // name of the owner
  private double co2;             // CO2 emission level
  private double co;              // CO emission level
  private double hc;              // HC emission level
  private String pollutionStatus; // Can be PASS, FAIL, PENDING
  private double constants[];     // Emission level constants - CO2, CO, HC

  // Functions
  public Vehicle(String reg, String mfg, String own, double con[]) {
    regNo = reg;
    manufacturer = mfg;
    owner = own;
    constants = con;
    pollutionStatus = "PENDING";
  }

  public void checkPollutionStatus() {
    if (co2 <= constants[0] && co <= constants[1] && hc <= constants[2])
      pollutionStatus = "PASS";
    else
      pollutionStatus = "FAIL";
  }

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
