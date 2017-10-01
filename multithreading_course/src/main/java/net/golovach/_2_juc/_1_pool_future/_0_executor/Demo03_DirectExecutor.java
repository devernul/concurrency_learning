package net.golovach._2_juc._1_pool_future._0_executor;

import java.util.concurrent.Executor;

/**
 * Created by kruart on 01.10.2017.
 */
public class Demo03_DirectExecutor {
    public static void main(String[] args) {
        //две задачи на Executor 1
        Executor executor0 = getExecutor();
        executor0.execute(getTask());
        executor0.execute(getTask());

        System.out.println("Hello from " + Thread.currentThread());
    }

    //DirectExecutor
    private static Executor getExecutor() {
        return command -> command.run();
    }

    private static Runnable getTask() {
        return () -> System.out.println("Hello from " + Thread.currentThread());
    }
}
