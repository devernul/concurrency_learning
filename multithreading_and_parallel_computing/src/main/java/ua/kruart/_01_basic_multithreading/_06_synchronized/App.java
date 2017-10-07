package ua.kruart._01_basic_multithreading._06_synchronized;

/**
 * Created by kruart on 07.10.2017.
 */
public class App {
    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        process();
        System.out.println(counter);
    }

    public static void process() throws InterruptedException {
        Thread th1 = new Thread(() -> {
            for (int i = 0; i < 20_000_000; i++) {
                increment();
            }
        });
        th1.start();

        Thread th2 = new Thread(() -> {
            for (int i = 0; i < 20_000_000; i++) {
                increment();
            }
        });
        th2.start();

        Thread th3 = new Thread(() -> {
            for (int i = 0; i < 20_000_000; i++) {
                increment();
            }
        });
        th3.start();

        th1.join();
        th2.join();
        th3.join();
    }

    private synchronized static int increment() {
        return ++counter;
    }
}
