package net.golovach._5_lecture15_forkjoin;

import java.util.stream.LongStream;

/**
 * Created by kruart on 06.10.2017.
 */
public class App04_stream_1_non_assoc {
    public static void main(String[] args) throws InterruptedException {

        LongStream.generate(() -> (long) (1000 * Math.random()));

        long result = LongStream.range(0, 1_000_000)
//                .parallel()
                .filter(x -> x % 3 != 0)
                .filter(x -> x % 5 != 0)
                .reduce(0, (x, y) -> 31 * x + y);

        System.out.println(result);

    }
}
