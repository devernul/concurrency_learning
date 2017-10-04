package net.golovach._3_monada._2_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by kruart on 04.10.2017.
 */
public class App20_completableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> f0 = CompletableFuture.supplyAsync(() -> {sleep(3000); return "A";});
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {sleep(1000); return "B";});

//        f0.acceptEitherAsync(f1, System.out::println);
        f0.thenAcceptBothAsync(f1, (a, b) -> System.out.println(a + " : " + b));
        Thread.sleep(4000);
    }

    private static void sleep(long dt) {
        try {
            Thread.sleep(dt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
