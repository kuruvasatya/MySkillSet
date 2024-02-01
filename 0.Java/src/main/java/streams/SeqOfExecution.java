package streams;

import java.util.Arrays;

public class SeqOfExecution {
    public static void main(String args[]) {
        int[] nums = new int[] {1, 2, 3, 4, 5, 6};
        int[] sorted = Arrays.stream(nums)
                .filter(num -> num >=4)
                .peek(e -> System.out.println("current ele:" + e))
                .map(e -> e*-1)
                .peek(e -> System.out.println("After mult: " + e))
                .sorted()
                .peek(e -> System.out.println("After sorted: "  + e))
                .toArray();

        Arrays.stream(sorted).forEach(e -> System.out.print( e  + " "));;
    }
}
