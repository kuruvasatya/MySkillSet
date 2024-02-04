package streams;
import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo {
    public static void main(String[] args) {
        int nums[] = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4};
        String[] words = new String[] {"one", "two", "three", "four", "five", "six"};

        List<Integer> list = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(list.toString());

        Set<Integer> set = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());
        System.out.println(set.toString());


        Map<String, Integer> map = Arrays.stream(words)
                .collect(Collectors.toMap((word) -> word, (word)-> word.length()));
        System.out.println(map.entrySet());

        String word = Arrays.stream(words)
                .collect(Collectors.joining(", "));
        System.out.println(word);

        Map<Boolean, List<Integer>> evenOdd = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));
        System.out.println(evenOdd.entrySet());

        Map<Boolean, List<Integer>> evenOdd2 = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(num -> num%2 == 0));
        System.out.println(evenOdd2.entrySet());

        Map<Character, Long> countOfGroup = Arrays.stream(words)
                .collect(Collectors.groupingBy(sword -> sword.charAt(0),  Collectors.counting()));
        System.out.println(countOfGroup);

    }
}
