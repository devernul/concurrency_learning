package net.golovach._2_juc._1_pool_future._0_executor;

import java.util.concurrent.Executor;

/**
 * Created by kruart on 01.10.2017.
 */
public class Demo01 {
    public static void main(String[] args) {
        //две задачи на Executor 1
        Executor executor0 = getExecutor();
        executor0.execute(getTask());
        executor0.execute(getTask());

        //три задачи на Executor 2
        Executor executor1 = getExecutor();
        executor1.execute(getTask());
        executor1.execute(getTask());
        executor1.execute(getTask());
    }

    private static Executor getExecutor() {
        throw new UnsupportedOperationException();
    }

    private static Runnable getTask() {
        throw new UnsupportedOperationException();
    }
}
