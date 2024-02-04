package streams;

import java.util.Optional;

public class OptinalExample {
    public static void main(String args[]) {
        // creation
        Optional empty = Optional.empty();
        Optional<String> stringOptional = Optional.of("Satya"); //if u use Optional.of(null) it gives run time exception
        Optional<String > stringOptional1 = Optional.ofNullable(null);

        System.out.println( empty + " "  + stringOptional1 + " " + stringOptional1 + " " +null );

        //check
        System.out.println(stringOptional.isPresent());
        System.out.println(stringOptional1.orElse("Ganesh"));
        stringOptional.ifPresent((String a) -> System.out.println(a));
        stringOptional1.ifPresentOrElse(
                (a) -> System.out.println(a),
                () -> System.out.println("empty")
        );

        String word = stringOptional1.map(wordM -> wordM)
                .orElse("Empty");
        System.out.println(word);

        String word1 = stringOptional.map(wordM -> wordM)
                .orElse("Empty");
        System.out.println(word1);


    }
}
