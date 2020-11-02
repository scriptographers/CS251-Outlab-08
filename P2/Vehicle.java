public class Vehicle{

    // Attributes
    private String regNo; // vehicle registration number
    private String manufacturer; //manufacturer name
    private String owner; // name of the owner
    private double co2; // CO2 emission level
    private double co; // CO emission level
    private double hc; // HC emission level
    private String pollutionStatus; // Can be PASS, FAIL, PENDING

    // Functions

    public Vehicle(String reg, String mfg, String own){
        regNo = reg;
        manufacturer = mfg;
        owner = own;
        pollutionStatus = "PENDING";
    }

    public void checkPollutionStatus(){
        // Not required/used
    }

    public String toString(){
        String info = String.format("Reg No: %s\n Manufacturer: %s\n Owner: %s\n Pollution Status: %s\n", regNo, manufacturer, owner, pollutionStatus);
        return info;
    }

    // Extra functions: Setters and Getters
    public void setPollutants(double co2, double co, double hc, String status){
        this.co2 = co2;
        this.co = co;
        this.hc = hc;
        this.pollutionStatus = status;
    }

    public String getPollutionStatus(){
        return pollutionStatus;
    }

}