// package P1;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
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

  public String[][] check_hash(String filepath) throws Exception {
    File file = new File(filepath);
    Scanner sc = new Scanner(file);
    ArrayList<String[]> res = new ArrayList<String[]>();

    while (sc.hasNextLine()) {
      String str = sc.nextLine();
      int i = str.lastIndexOf("-");
      String[] x = { str.substring(0, i), str.substring(i + 1) };
      String hash = this.hasher(x[0].trim());
      if (hash.equals(x[1].trim())) {
        x[1] = "verified";
      } else {
        x[1] = "not verified";
      }
      res.add(x);
    }
    sc.close();

    return res.toArray(new String[2][0]);
  }

  public static void main(String[] args) throws Exception {
    MD5 obj = new MD5();

    String[][] res = obj.check_hash("MD5sums");
    for (int i = 0; i < res.length; i++) {
      System.out.println(res[i][1]);
    }
  }
}
