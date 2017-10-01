package net.golovach._2_juc._1_pool_future._0_executor;

/**
 * Created by kruart on 01.10.2017.
 */
public class Demo00 {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("Hello!");
        new Thread(task).start();
    }
}
