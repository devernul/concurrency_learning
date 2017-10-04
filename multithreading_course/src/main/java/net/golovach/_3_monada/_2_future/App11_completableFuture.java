package net.golovach._3_monada._2_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by kruart on 04.10.2017.
 */
public class App11_completableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture.supplyAsync(() -> "42")
                .thenApply(Integer::valueOf)
                .thenApply(x -> Math.PI * x * x)
                .thenAccept(System.out::println);


    }
}
