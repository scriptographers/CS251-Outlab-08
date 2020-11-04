import java.util.*;  
import java.util.stream.IntStream; 
import java.util.stream.Collectors;

public class Sieve{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        n += 1; // if n is prime, it gets printed too

        List<Integer> nums = IntStream.range(2, n).boxed().collect(Collectors.toList());
        List<Integer> divisors = IntStream.range(2, (int)Math.ceil(Math.sqrt(n))).boxed().collect(Collectors.toList());

        divisors.stream().forEach(p -> {
            nums.removeIf(x -> (x%p == 0 && x!=p));
        });

        System.out.println(nums.toString().replaceAll("[,\\[\\]]", ""));
    }
}