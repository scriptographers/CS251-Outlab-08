import java.util.*;

public class StreamingAppTest {
  public static void main(String[] args) {
    Map<String, ArrayList<String>> UM = new HashMap<>(); // user-movies map
    Map<String, ArrayList<String>> GM = new HashMap<>(); // genre-movies map

    UM.put("David", new ArrayList<String>());
    UM.put("Emma", new ArrayList<String>());

    UM.get("David").add("The Conjuring");
    UM.get("David").add("Shoah");
    UM.get("David").add("The Purge");
    UM.get("David").add("13th");
    UM.get("David").add("The Dictator");
    UM.get("Emma").add("The Matrix");
    UM.get("Emma").add("Captain America: Civil War");
    UM.get("Emma").add("John Wick");

    GM.put("Horror", new ArrayList<String>());
    GM.put("Action", new ArrayList<String>());
    GM.put("Documentary", new ArrayList<String>());
    GM.put("Science Fiction", new ArrayList<String>());
    GM.put("Comedy", new ArrayList<String>());

    GM.get("Horror").add("The Conjuring");
    GM.get("Horror").add("The Purge");
    GM.get("Action").add("John Wick");
    GM.get("Documentary").add("Shoah");
    GM.get("Documentary").add("13th");
    GM.get("Science Fiction").add("The Matrix");
    GM.get("Science Fiction").add("Captain America: Civil War");
    GM.get("Comedy").add("The Dictator");

    System.out.println(UM);
    System.out.println(GM);

    Map<String, ArrayList<String>> UF = StreamingApp.getFavouriteGenres(UM, GM);
    System.out.println(UF);
  }
}
