package streams;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main1 {
    public static void main(String args[]) {
        /**
         * Creating stream
         * 1. Stream.of(T, T) => return Stream<T> : T may be Integer, String, int[] (array)
         * 2. Arrays to stream => Arrays.stream()
         * 3. Collection to stream => <Collection>.stream()
         */
        Stream<Integer> stream11 = Stream.of(1, 2, 3, 4);
        Stream<String> stream12 = Stream.of("abc", "xyz");

        // arrays
        int[] intArray = new int[] {1, 2, 3, 4};
        Stream<Integer> stream21 = Arrays.stream(intArray).boxed(); // Arrays.stream(int[] array) returns IntStream
        String[] stringArray = new String[] {"abc", "xyz"};
        Stream<String> stream22 = Arrays.stream(stringArray);

        Map<String, Integer> hm = new HashMap();
        hm.put("abc", 1);
        hm.put("xyz", 2);
        hm.put("mnp", 3);
        hm.forEach((key, value) -> hm.replace(key, value  +1));

        Stream.iterate(10,(Integer n) -> n+1).limit(10).forEach(System.out::println);

    }
}
