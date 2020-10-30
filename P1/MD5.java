import java.io.File;
import java.util.Scanner;
import java.security.*;
import java.math.BigInteger;

public class MD5 {
  public String hasher(String s) throws NoSuchAlgorithmException {
    MessageDigest m = MessageDigest.getInstance("MD5");
    m.reset();
    m.update(s.getBytes());
    byte[] digest = m.digest();
    BigInteger bigInt = new BigInteger(1, digest);
    String hash = bigInt.toString(16);
    // Now we need to zero pad it if you actually want the full 32 chars.
    while (hash.length() < 32) {
      hash = "0" + hash;
    }
    return hash;
  }

  public static void main(String[] args) throws Exception {
    MD5 obj = new MD5();
    File file = new File("MD5sums");
    Scanner sc = new Scanner(file);

    while (sc.hasNextLine()) {
      String str = sc.nextLine();
      int i = str.lastIndexOf("-");
      String[] x = { str.substring(0, i), str.substring(i + 1) };
      String hash = obj.hasher(x[0].trim());
      if (hash.equals(x[1].trim())) {
        System.out.println("verified");
      } else {
        System.out.println("not verified");
      }
    }
  }
}
