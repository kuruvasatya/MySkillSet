package streams;


import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class CustomFunction implements Function<Integer, String> {
    @Override
    public String apply(Integer integer) {
        return integer + "";
    }
}

class CustomPredicate implements Predicate<Integer> {
    @Override
    public boolean test(Integer integer) {
        return integer % 2 == 0;
    }
}

class CustomConsumer implements Consumer<Integer> {
    @Override
    public void accept(Integer t) {
        System.out.println(t);
    }
}

class CustomSupplier implements Supplier<Integer> {
    @Override
    public Integer get() {
        return -1;
    }
}

public class FunctionalInterfaces {
    public static void main(String argsp[]) {
        List<Integer> list = IntStream.rangeClosed(1,10)
                .boxed().collect(Collectors.toList());

        // use of custom map
        List<String> s = list.stream()
                .map(new CustomFunction())
                .collect(Collectors.toList());

        //use of lambda
        List<String> s2 = list.stream()
                .map((e) -> e+"")
                .collect(Collectors.toList());


        // use of filter
        List<Integer> even = list.stream()
                .filter(n -> (n&1) == 1)
                .collect(Collectors.toList());
        List<Integer> evenL = list.stream()
                .filter((e) -> (e&1) == 1)
                .collect(Collectors.toList());


        // use of consumer
        list.stream().forEach(new CustomConsumer());
        list.stream().forEach(System.out::println);

        // use of supplier
        System.out.println(Collections.emptyList().stream().findAny().orElseGet(new CustomSupplier()));
        System.out.println(Collections.emptyList().stream().findAny().orElseGet(()->5));
    }
}
