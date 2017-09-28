package net.golovach._1_hardware_math._x_monitor;

/**
 * Created by kruart on 28.09.2017.
 */
public class App07 {
    static volatile boolean in = false;

    public static void main(String[] args) throws InterruptedException {
        final Object monitor = new Object();
        new Thread(() -> {
            synchronized (monitor) {
                in = true;
                while (true) {
                    Thread.yield();
                }

            }
        }).start();

        Thread.sleep(1000);
        System.out.println("A");
        System.out.println("B");
        synchronized (monitor) {System.out.println("C"); }
    }
}
