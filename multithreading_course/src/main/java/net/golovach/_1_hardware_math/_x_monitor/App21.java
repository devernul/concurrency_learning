package net.golovach._1_hardware_math._x_monitor;

/**
 * Created by kruart on 28.09.2017.
 */
public class App21 {
    private static int counter = 0; //we don't need volatile here
    private static volatile boolean finish0 = false;
    private static volatile boolean finish1 = false;

    //Spec: An unlock on a monitor happens-before every subsequent lock on the same monitor.
    private static synchronized void inc() {
        counter++;
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
