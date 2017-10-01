package net.golovach._2_juc._1_pool_future._0_executor;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by kruart on 01.10.2017.
 */
public class Demo02_ThreadPerTaskExecutor {
    public static void main(String[] args) {
        //две задачи на Executor 1
        Executor executor0 = getExecutor();
        executor0.execute(getTask());
        executor0.execute(getTask());
        executor0.execute(getTask());

        System.out.println("Hello from " + Thread.currentThread());
    }

    //ThreadPerTaskExecutor
    private static Executor getExecutor() {
        return new Executor() {
            private final AtomicLong index = new AtomicLong(0);
            private final ThreadGroup group = new ThreadGroup("juveTeam");
            @Override
            public void execute(Runnable command) {
                Thread thread = new Thread(group, command);
                thread.setPriority(Thread.NORM_PRIORITY + 1);
                thread.setDaemon(true);
                thread.setName("Thread #" + index.getAndIncrement());
                thread.start();
            }
        };
    }

    private static Runnable getTask() {
        return () -> System.out.println("Hello from " + Thread.currentThread());
    }
}
