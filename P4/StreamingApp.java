/*
DO NOT MODIFY THE CODE STUB
NO NEED TO DEFINE main()
*/

import java.util.*;

class StreamingApp {
  public static Map<String, ArrayList<String>>
  getFavouriteGenres(Map<String, ArrayList<String>> userMovies,
                     Map<String, ArrayList<String>> movieGenres) {

    // Renaming ambiguous parameters
    if (userMovies == null || movieGenres == null) {
      Map<String, ArrayList<String>> UF = new HashMap<>(); // empty map
      return UF;
    }
    Map<String, ArrayList<String>> UM = userMovies;  // user-movies map
    Map<String, ArrayList<String>> GM = movieGenres; // genre-movies map

    // Create movie-genre map, a movie will have a single genre
    Map<String, String> MG = new HashMap<>();
    for (Map.Entry<String, ArrayList<String>> entry : GM.entrySet()) {
      for (String movie : entry.getValue())
        if (!MG.containsKey(movie))
          MG.put(movie, entry.getKey());
    }

    // Create user-favgenres map
    Map<String, ArrayList<String>> UF = new HashMap<>();
    for (Map.Entry<String, ArrayList<String>> entry : UM.entrySet()) {

      ArrayList<String> temp = new ArrayList<>();
      for (String movie : entry.getValue())
        temp.add(MG.get(movie));

      // Create genre-freq map for temp
      Map<String, Integer> GF = new HashMap<>();
      int maxFreq = 0;
      for (String genre : temp) {
        int currentCount = GF.containsKey(genre) ? GF.get(genre) : 0;
        if (currentCount + 1 >= maxFreq)
          maxFreq = currentCount + 1;
        GF.put(genre, currentCount + 1);
      }

      ArrayList<String> favourites = new ArrayList<>();
      for (Map.Entry<String, Integer> gf_entry : GF.entrySet())
        if (gf_entry.getValue() == maxFreq)
          favourites.add(gf_entry.getKey());

      UF.put(entry.getKey(), favourites);
    }

    return UF;
  }
}
