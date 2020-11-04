public class Truck extends Vehicle {
  private static double constants[] = {25, 0.8, 1000};

  public Truck(String reg, String mfg, String own) {
    super(reg, mfg, own, constants);
  }
}
