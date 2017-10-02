package net.golovach._2_juc._3_java8_parallel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kruart on 02.10.2017.
 */
public class App00 {
    public static void main(String[] args) {
        new Thread(App00::printHello).start();
        new Thread(() -> System.out.println("Hello!")).start();

        List<String> list = Arrays.asList("A", "BB", "CCC");
        list.parallelStream()
                .map(String::length)
                .filter(k -> k % 2 == 1)
                .forEach(System.out::println);

        list.forEach(System.out::println);

        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            strings.add("Juventus-" + i);
        }

        long l1 = System.currentTimeMillis();
        Integer sum1 = strings.stream()
                .map(s -> s.substring(s.length() - 3))
                .filter(s -> s.contains("777"))
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
        System.out.println(sum1);
        System.out.println(System.currentTimeMillis() - l1);

        l1 = System.currentTimeMillis();
        Integer sum2 = strings.parallelStream()
                .map(s -> s.substring(s.length() - 3))
                .filter(s -> s.contains("777"))
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
        System.out.println(sum2);

        System.out.println(System.currentTimeMillis() - l1);

    }

    private static void printHello() {
        System.out.println("Hello!");
    }
}
