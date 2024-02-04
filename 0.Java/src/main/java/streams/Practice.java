package streams;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


class Employee {
    private String name;
    private String dept;
    private long salary;

    public Employee(String name, String dept, Long salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class Practice {
    public static void main(String args[]) {
        int[] nums = IntStream.rangeClosed(1,100)
                .map(i -> new Random().nextInt(1, 10))
                .limit(15)
                .toArray();
        String[] words = IntStream.rangeClosed(1,100)
                .mapToObj(i -> "word"+new Random().nextInt(1, 10) )
                .limit(15)
                .toArray(String[]::new);
        String stringword = "IamJavaDeveloper";


        //1. seperate even and odd
        Map<Boolean, List<Integer>> evenOdd = Arrays.stream(nums).boxed()
                .collect(Collectors.partitioningBy(num -> num%2 == 0));
        System.out.println("Even Odd " + evenOdd.entrySet());

        //2. remove duplicates from list
        List<Integer> non_duplicates = Arrays.stream(nums).distinct().boxed().collect(Collectors.toList());
        System.out.println("Non_duplicates: "  + non_duplicates.toString());

        //3. frequency of character in a string-
        Map<Character, Long> freq = stringword.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        System.out.println("freq: " + freq.entrySet());

        //4. frequency of each element in list
        Map<Integer, Long> intFreq = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        System.out.println("freq Array: " + intFreq);

        //5. Sort elements in reverse order
        List<Integer> reversed = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("revesed sorted: " + reversed);

        //6. join string with prefix, suffix and delimiter
        String s = Arrays.stream(words).collect(Collectors.joining("," , "pre", "post"));
        System.out.println(s);

        //7. min and max
        int min = Arrays.stream(nums).min().orElse(0);
        int max = Arrays.stream(nums).max().orElse(0);
        System.out.println("min: " + min + " max:" + max);

        String s1 = "anagram";
        String s2 = "margana";

        // 8. anagrams
        String s11 = Stream.of(s1.split("")).map(String::toLowerCase).sorted().collect(Collectors.joining());
        String s12 = Stream.of(s2.split("")).map(String::toLowerCase).sorted().collect(Collectors.joining());
        System.out.println("Are they anagrams: " + s11.equals(s12));

        // 9. sum of all digits in a number
        int num = 123456789;
        int sum = Stream.of((num+"").split("")).mapToInt(c -> Integer.parseInt(c)).sum();
        System.out.println("sum is:" + sum);

        // 10. second largest element in array
        int secondLargest = Arrays.stream(nums).boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(-1);

        // 11. sort list of strings in decreasing order of their length, if they are of same length then
        // alphabetically reverse sorted
        String[] strings = new String[] {"abc", "xy", "mnop", "pqr", "abd"};
        List<String> sortByLength = Arrays.stream(strings)
                .sorted(Comparator.comparing(String::length, Comparator.reverseOrder())
                        .thenComparing(Comparator.reverseOrder()))
                .collect(Collectors.toList());
        System.out.println(sortByLength.toString());

//        12. find max salary in each dept
        List<Employee> employees = Arrays.asList(
                new Employee("Satya", "DEV", 80000L),
                new Employee("Ganesh", "DEV", 50000L),
                new Employee("Ramesh", "OPS", 25000L),
                new Employee("Sita", "QA", 90000L),
                new Employee("Priya", "QA", 60000L)
        );

        Map<String, Optional<Employee>> collect = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDept,
                        Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))));

        System.out.println(collect.entrySet());

        Map<String, Long> collect1 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.counting()));
        System.out.println(collect1);

        Map<String, Long> collect2 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.summingLong(Employee::getSalary)));
        System.out.println(collect2);
    }
}
