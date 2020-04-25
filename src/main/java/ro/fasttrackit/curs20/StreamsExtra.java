package ro.fasttrackit.curs20;

import javax.crypto.spec.PSource;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsExtra {
    public static void main(String[] args) {
        IntStream.range(1, 11)
                .forEach(System.out::println);

        System.out.println(
                IntStream.range(20, 40)
                        .sum()
        );


        System.out.println(
                IntStream.range(20, 40)
                        .average()
        );

        System.out.println(
                IntStream.range(20, 40)
                        .count()
        );

        System.out.println(
                IntStream.range(20, 40)
                        .filter(elem -> elem % 2 == 0)
                        .sum()
        );

        System.out.println(IntStream.range(20, 40)
                .max());


        System.out.println(IntStream.range(20, 40)
                .min());

        int[] ints = new int[]{1, 5, 6, 7, 8, 32, 321};
        System.out.println(IntStream.of(ints)
                .min());
        IntStream.of(ints)
                .map(a -> a + 1)
                .forEach(System.out::print);


        System.out.println(IntStream.of(ints)
                .mapToObj(a -> "elements " + a)
                .collect(Collectors.joining("~")));


    }


}



