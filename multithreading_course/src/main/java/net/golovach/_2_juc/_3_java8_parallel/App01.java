package net.golovach._2_juc._3_java8_parallel;

import java.util.stream.Stream;

/**
 * Created by kruart on 02.10.2017.
 */
public class App01 {
    public static void main(String[] args) {
        Stream<Long> stream = Stream.iterate(2L, k -> k + 3);
        stream.limit(10).forEach(System.out::println);
    }
}
