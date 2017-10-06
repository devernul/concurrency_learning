package net.golovach._5_lecture15_forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by kruart on 06.10.2017.
 */
public class App00_iterative_1 {
    public static void main(String[] args) throws InterruptedException {
        AtomicLong result = new AtomicLong(0);
        int cpuCount = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(cpuCount);

        List<Callable<Void>> taskList = new ArrayList<>();

        long a = System.currentTimeMillis();
        for (int k = 0; k < 100; k++) {
            final int finalK = k;
            taskList.add(() -> {
                //[0 ... 9999], [10000 ... 19999], ...
                long localResult = calc(10_000 * finalK, 10_000 * (finalK + 1));
                result.addAndGet(localResult);
                return null;
            });
        }

        //final barrier
        pool.invokeAll(taskList);

        System.out.println(System.currentTimeMillis() - a);
        System.out.println(result);
        pool.shutdown();
    }

    private static long calc(int from, int to) {
        long result = 0;
        for (int index = from; index < to; index++) {
            if (index % 3 != 0 && index % 5 != 0) {
                result += index;
            }
        }
        return result;
    }
}
