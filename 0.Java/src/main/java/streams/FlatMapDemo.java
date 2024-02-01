package streams;
import java.util.*;
import java.util.stream.IntStream;

public class FlatMapDemo {
    public static void main(String args[]) {
        List<List<Integer>> nested = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        for(int i=1; i<= 25; i++) {
            subList.add(i);
            if( i %5 == 0) {
                nested.add(subList);
                subList = new ArrayList<>();
            }
        }
        System.out.println(nested);
        nested.stream().forEach(e -> System.out.print(e + " "));
        System.out.println();
        nested.stream().flatMap(e -> e.stream()).forEach(e -> System.out.print(e + " "));
    }
}
