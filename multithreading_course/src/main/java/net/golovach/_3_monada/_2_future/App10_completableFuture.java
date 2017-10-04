package net.golovach._3_monada._2_future;

import java.lang.ref.WeakReference;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by kruart on 04.10.2017.
 */
public class App10_completableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> f0 =
                CompletableFuture.supplyAsync(() -> {for (int k = 0; k < Long.MAX_VALUE; k++); return "42";});
        CompletableFuture<Integer> f1 = f0.thenApply(Integer::valueOf);
        CompletableFuture<Double> f2 = f1.thenApply(x -> Math.PI * x * x);
        f2.thenAccept(System.out::println);
        System.out.println("end");

        WeakReference<Integer> ref = new WeakReference<>(42);
        System.out.println(ref.get());


    }
}
