package net.golovach._3_monada._2_future;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

/**
 * Created by kruart on 04.10.2017.
 */
public class App02 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();

        byte[] bytes = pool.invokeAny(Arrays.asList(
                () -> readAllBytes(get("multithreading_course/src/main/resources/tmp0.txt")),
                () -> readAllBytes(get("multithreading_course/src/main/resources/tmp1.txt")),
                () -> readAllBytes(get("multithreading_course/src/main/resources/tmp2.txt"))));

        System.out.println(new String(bytes));

        pool.shutdown();
    }
}
