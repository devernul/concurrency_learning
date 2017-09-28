package net.golovach._1_hardware_math._x_monitor;

/**
 * Created by kruart on 28.09.2017.
 */
public class App20 {
    private static volatile int counter = 0;
    private static volatile boolean finish0 = false;
    private static volatile boolean finish1 = false;

    //lost update
    private static /*synchronized*/ void inc() {
        counter++;
        //because increment(++) is not atomic operation, It consists of three parts:
        //int tmp = counter;
        //tmp = tmp + 1;
        //counter = tmp;
    }

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            for (int i = 0; i < 10_000_000; i++) {
                inc();
            }
            finish0 = true;

        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10_000_000; i++) {
                inc();
            }
            finish1 = true;

        }).start();

        while (!finish0 || !finish1);

        System.out.println(counter);
    }
}
