package net.golovach._2_juc._3_java8_parallel;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by kruart on 02.10.2017.
 */
public class App10 {
    public static void main(String[] args) {
        Supplier<Double> s = Math::random;
        Function<String, Integer> f = Integer::valueOf;
        Predicate<Integer> p = (arg) -> arg > 1;

        Arrays.asList("1", "2 33", "4 55 666")
                .stream()
                .flatMap(str -> Arrays.stream(str.split(" ")))
                .forEach(System.out::println);
    }
}
