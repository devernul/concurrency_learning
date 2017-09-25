package net.golovach._1_hardware_math._0_hardware._3_false_sharing;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kruart on 25.09.2017.
 */
public class FalseSharingDetector {
    volatile static long value0 = 0;
    volatile static long value1 = 0;
    volatile static long value2 = 0;
    volatile static long value3 = 0;
    volatile static long value4 = 0;
    volatile static long value5 = 0;
    volatile static long value6 = 0;
    volatile static long value7 = 0;
    volatile static long value8 = 0;    //can't be in the same cache line as value0, because cache line == 64 bits(8 bytes)

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        final CountDownLatch latch0 = new CountDownLatch(2);
        final CountDownLatch latch2 = new CountDownLatch(2);
        pool.submit((Callable<Void>) () -> {
            latch0.countDown(); //Thread #1 ready
            latch0.await();    //Wait for start signal
            long t0 = System.nanoTime();
            for (int i = 0; i < 100_000_000; i++) {
                value0 = value0 * i;
            }
            long t1 = System.nanoTime();
            System.out.println((t1 - t0) / 1000000 + "ms");
            latch2.countDown(); //Thread #1 finished
            return null;
        });

        pool.submit((Callable<Void>) () -> {
            latch0.countDown(); //Thread #2 ready
            latch0.await();    //Wait for start signal
            long t0 = System.nanoTime();
            for (int i = 0; i < 100_000_000; i++) {
//                value1 = value1 * i;
                value8 = value8 * i;
            }
            long t1 = System.nanoTime();
            System.out.println((t1 - t0) / 1000000 + "ms");
            latch2.countDown(); //Thread #2 finished
            return null;
        });
        latch2.await();     //Wait for #1 + #2 threads finished
        pool.shutdownNow(); //kill thread pool
    }
}
