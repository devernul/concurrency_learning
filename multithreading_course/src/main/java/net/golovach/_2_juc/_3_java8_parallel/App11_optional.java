package net.golovach._2_juc._3_java8_parallel;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by kruart on 02.10.2017.
 */
public class App11_optional {
    public static void main(String[] args) {
        Optional<Integer> sum = Stream.iterate(1, k -> k + 1)
                .parallel()
                .limit(10)
                .reduce((x, y) -> x + y);

        System.out.println(sum);
    }
}
