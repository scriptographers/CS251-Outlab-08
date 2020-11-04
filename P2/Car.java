public class Car extends Vehicle {
  private static double constants[] = {15, 0.5, 750};

  public Car(String reg, String mfg, String own) {
    super(reg, mfg, own, constants);
  }
}
