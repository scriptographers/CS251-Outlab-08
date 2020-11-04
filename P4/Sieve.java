import java.util.*;  
import java.util.stream.IntStream; 
import java.util.stream.Collectors;

public class Sieve{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        n += 1; // if n is prime, it gets printed too

        // Create potential primes 
        List<Integer> nums = IntStream.range(2, n).boxed().collect(Collectors.toList());
        
        // Filter nums based on divisors
        IntStream.range(2, (int)Math.ceil(Math.sqrt(n))).boxed().map(p -> nums.removeIf(x -> (x%p == 0 && x!=p))?0:0).collect(Collectors.toList());
        
        // Print final list, replace all '[', ',' and ']' by ""
        System.out.println(nums.toString().replaceAll("[,\\[\\]]", ""));
    }
}