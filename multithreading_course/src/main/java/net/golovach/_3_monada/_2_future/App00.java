package net.golovach._3_monada._2_future;

import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

/**
 * Created by kruart on 04.10.2017.
 */
public class App00 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();

        Future<byte[]> futBytes0 = pool.submit(() -> readAllBytes(get("multithreading_course/src/main/resources/tmp0.txt")));
        Future<byte[]> futBytes1 = pool.submit(() -> readAllBytes(get("multithreading_course/src/main/resources/tmp1.txt")));
        Future<byte[]> futBytes2 = pool.submit(() -> readAllBytes(get("multithreading_course/src/main/resources/tmp2.txt")));

        System.out.println(futBytes0.isDone());
        System.out.println(futBytes1.isDone());
        System.out.println(futBytes2.isDone());
        byte[] bytes0 = futBytes0.get();
        byte[] bytes1 = futBytes1.get();
        byte[] bytes2 = futBytes2.get();
        System.out.println(futBytes0.isDone());
        System.out.println(futBytes1.isDone());
        System.out.println(futBytes2.isDone());
        System.out.println(Arrays.toString(bytes0));
        System.out.println(Arrays.toString(bytes1));
        System.out.println(Arrays.toString(bytes2));
        pool.shutdown();
    }
}
