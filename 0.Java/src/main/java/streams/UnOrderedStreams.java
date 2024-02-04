package streams;

import java.util.*;

public class UnOrderedStreams {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("B", "A", "C", "D", "F");
        Set<String> set = new TreeSet<>(list);

        long start1 = System.currentTimeMillis();
        String[] listOutput = list.stream().toArray(String[]::new);
        String[] setOutput = set.stream().toArray(String[]::new);
        long end1 = System.currentTimeMillis();

        System.out.println((end1-start1) + " without parallel streams and unordered() not used..");
        System.out.println(Arrays.toString(listOutput));
        System.out.println(Arrays.toString(setOutput));

        long start2 = System.currentTimeMillis();
        String[] listOutput2 = list.stream().parallel().toArray(String[]::new);
        String[] setOutput2 = set.stream().parallel().toArray(String[]::new);
        long end2 = System.currentTimeMillis();

        System.out.println((end2-start2) + " with parallel streams and unordered not used");
        System.out.println(Arrays.toString(listOutput2));
        System.out.println(Arrays.toString(setOutput2));


        long start3 = System.currentTimeMillis();
        String[] listOutput1 = list.stream().unordered().toArray(String[]::new);
        String[] setOutput1 = set.stream().unordered().toArray(String[]::new);
        long end3 = System.currentTimeMillis();

        System.out.println((end3-start3) + " without parallel stream and unordered used..");
        System.out.println(Arrays.toString(listOutput1));
        System.out.println(Arrays.toString(setOutput1));

        long start4 = System.currentTimeMillis();
        String[] listOutput3 = list.stream().unordered().parallel().toArray(String[]::new);
        String[] setOutput3 = set.stream().unordered().parallel().toArray(String[]::new);
        long end4 = System.currentTimeMillis();
        System.out.println((end4-start4) + " with parallel streams and unordered()");
        System.out.println(Arrays.toString(listOutput3));
        System.out.println(Arrays.toString(setOutput3));
    }
}
