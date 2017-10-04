package net.golovach._3_monada._2_future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

/**
 * Created by kruart on 04.10.2017.
 */
public class App01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();

        List<Future<Object>> liftFutBytes = pool.invokeAll(Arrays.asList(
                () -> readAllBytes(get("multithreading_course/src/main/resources/tmp0.txt")),
                () -> readAllBytes(get("multithreading_course/src/main/resources/tmp1.txt")),
                () -> readAllBytes(get("multithreading_course/src/main/resources/tmp2.txt"))));

        System.out.println(liftFutBytes.get(0).isDone());
        System.out.println(liftFutBytes.get(1).isDone());
        System.out.println(liftFutBytes.get(2).isDone());

        pool.shutdown();
    }
}
