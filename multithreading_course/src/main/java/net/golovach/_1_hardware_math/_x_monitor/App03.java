package net.golovach._1_hardware_math._x_monitor;

/**
 * Created by kruart on 28.09.2017.
 */
public class App03 {
    public static void main(String[] args) throws InterruptedException {
        final Object monitor = new Object();
        new Thread(() -> {
            System.out.println(0);
            synchronized (monitor) {
                while (true) {
                    System.out.println("A");
                }
            }
        }).start();

        new Thread(() -> {
            System.out.println(1);
            synchronized (monitor) {
                while (true) {
                    System.out.println("B");
                }
            }
        }).start();
    }
}
