package net.golovach._5_lecture15_forkjoin;

import java.util.stream.LongStream;

/**
 * Created by kruart on 06.10.2017.
 */
public class App03_stream_0 {
    public static void main(String[] args) throws InterruptedException {

        //good
        long result1 = LongStream.range(0, 1_000_000)
                .parallel()
                .filter(x -> x % 3 != 0)
                .filter(x -> x % 5 != 0)
//                .filter(x -> x % 3 != 0 && x % 5 != 0)
                .sum();
        System.out.println(result1);

        //bad: low speed generation + boxing/unboxing
        long result2 = LongStream.range(0, 1_000_000)
                .parallel()
                .filter(x -> x % 3 != 0)
                .filter(x -> x % 5 != 0)
                .reduce(0, (x, y) -> x + y);

        System.out.println(result2);
    }
}
