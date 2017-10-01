package net.golovach._2_juc._1_pool_future._0_executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by kruart on 01.10.2017.
 */
public class Demo06_Executors {
    public static void main(String[] args) {
//        Executor executor = Executors.newSingleThreadExecutor();
//        Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Executor executor = Executors.newCachedThreadPool();

        executor.execute(getTask());
        executor.execute(getTask());
        executor.execute(getTask());
        executor.execute(getTask());
        executor.execute(getTask());
        executor.execute(getTask());
    }

    private static Runnable getTask() {
        return () -> System.out.println("Hello from " + Thread.currentThread());
    }
}
