package ua.kruart._01_basic_multithreading._13_callable_future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by kruart on 07.10.2017.
 */
public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);

        List<Future<String>> futures = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Future<String> future = service.submit(new Processor(i));
            futures.add(future);
        }

        for (Future<String> future : futures) {
            System.out.println(future.get());
        }

        service.shutdown();
    }
}

class Processor implements Callable<String> {
    private int id;

    public Processor(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "Id: " + id;
    }
}
