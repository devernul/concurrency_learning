package net.golovach._2_juc._1_pool_future._0_executor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by kruart on 01.10.2017.
 */
public class Demo05_ThreadPoolExecutor {
    public static void main(String[] args) {
        int corePoolSize = 4;
        int maximumPoolSize = 64;
        long keepAliveTime = 10;
        TimeUnit unit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(256);
        ThreadFactory threadFactory = new ThreadFactory() {
            private AtomicInteger counter = new AtomicInteger(0);
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setPriority(Thread.NORM_PRIORITY);
                thread.setName("MyPool-NORM_PRIORITY-" + counter.incrementAndGet());
                return thread;
            }
        };

        RejectedExecutionHandler rejectedHandler =
                (r, executor) -> System.out.println("All thread busy + task queue is full");

        Executor executor =
                new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, rejectedHandler);

        executor.execute(getTask());
        executor.execute(getTask());
        executor.execute(getTask());
    }

    private static Runnable getTask() {
        return () -> System.out.println("Hello from " + Thread.currentThread());
    }
}
