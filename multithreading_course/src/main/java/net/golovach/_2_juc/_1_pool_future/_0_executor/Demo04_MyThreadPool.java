package net.golovach._2_juc._1_pool_future._0_executor;

import java.util.concurrent.Executor;
import java.util.stream.IntStream;

/**
 * Created by kruart on 01.10.2017.
 */
public class Demo04_MyThreadPool {
    public static void main(String[] args) {
        //две задачи на Executor 1
        Executor executor0 = new MyThreadPool(2);
        IntStream.range(0, 10).forEach(i -> doSomething(executor0));
    }

    private static void doSomething(Executor executor0) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor0.execute(getTask());
        executor0.execute(getTask());
        executor0.execute(getTask());
        executor0.execute(getTask());
    }

    private static Runnable getTask() {
        return () -> System.out.println("Hello from " + Thread.currentThread());
    }
}
