import java.io.*;
import java.util.*;

public class PollutionCheck {
  public static void main(String[] args) throws IOException {

    // File paths
    String vpath = args[0];
    String ppath = args[1];
    String qpath = args[2];

    // File objs
    File vfile = new File(vpath);
    File pfile = new File(ppath);
    File qfile = new File(qpath);

    String line;
    Map<String, Vehicle> data = new HashMap<String, Vehicle>();

    // Reading the Vehicles data:
    FileReader vfr = new FileReader(vfile);
    BufferedReader vfbr = new BufferedReader(vfr);

    while ((line = vfbr.readLine()) != null) {

      String info[] = line.trim().split("\\s*,\\s*"); // trim and split

      if (info[3].equals("Car")) {
        Car c = new Car(info[0], info[1], info[2]);
        data.put(info[0], c);
      } else if (info[3].equals("Truck")) {
        Truck t = new Truck(info[0], info[1], info[2]);
        data.put(info[0], t);
      } else {
        // Invalid
      }
    }
    vfr.close();

    // Reading the Pollutants Data:
    FileReader pfr = new FileReader(pfile);
    BufferedReader pfbr = new BufferedReader(pfr);

    while ((line = pfbr.readLine()) != null) {
      String info[] = line.trim().split("\\s*,\\s*"); // trim and split
      if (data.containsKey(info[0])) {
        Vehicle temp = data.get(info[0]);

        temp.setPollutants(Double.parseDouble(info[1]),
                           Double.parseDouble(info[2]),
                           Double.parseDouble(info[3]));
        data.replace(info[0], temp);
      }
    }
    pfr.close();

    // Reading queries
    FileReader qfr = new FileReader(qfile);
    BufferedReader qfbr = new BufferedReader(qfr);

    while ((line = qfbr.readLine()) != null) {
      String query = line.trim();
      if (data.containsKey(query)) {
        Vehicle temp = data.get(query);
        System.out.println(temp.getPollutionStatus());
      } else {
        System.out.println("NOT REGISTERED");
      }
    }
    qfr.close();

    // System.out.println(data);
  }
}
