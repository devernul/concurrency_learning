package net.golovach._2_juc._3_java8_parallel;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by kruart on 02.10.2017.
 */
public class App03 {
    public static void main(String[] args) {
        Set<Integer> set = Set.of(1, 2, 3);

        Stream<Integer> streamInt = set.stream();
        Set<String> streamString = set.stream().map(k -> "~" + k).collect(Collectors.toSet());
    }
}

@FunctionalInterface
interface I {
    void fun1(int k);
    default void fun2(int k) {}
}
