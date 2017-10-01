package net.golovach._2_juc._1_pool_future._1_executor_service;

import java.util.List;
import java.util.concurrent.*;

/**
 * Created by kruart on 01.10.2017.
 */
public class Demo00_submit {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService execService = Executors.newCachedThreadPool();

        Future<Integer> future0 = execService.submit(() -> 42); //callable
        Future<Integer> future1 = execService.submit(() -> {    //callable
            while(true) {/*infinity loop*/
                if (Thread.interrupted()) throw new InterruptedException();
            }});

        Thread.sleep(1000);
        System.out.println("future0.isDone(): " + future0.isDone());
        System.out.println("future1.isDone(): " + future1.isDone());

        System.out.println("future0.get(): " + future0.get());
        System.out.println("future1.get(): " + future0.get());  //block here
        System.out.println("FINISH");

        Callable<Integer> call0 = () -> 21;
        Callable<Integer> call1 = () -> 45;
        Callable<Integer> call2 = () -> 77;

        Integer any = execService.invokeAny(List.of(call0, call1, call2));
        System.out.println("ANY: " + any);

        List<Future<Integer>> resultFutures = execService.invokeAll(List.of(call0, call1, call2));
        for (Future<Integer> futureTask : resultFutures) {
            System.out.println(futureTask.get());
        }

        execService.shutdownNow();
    }
}
