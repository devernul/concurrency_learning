package net.golovach._1_hardware_math._x_monitor;

/**
 * Created by kruart on 28.09.2017.
 */
public class App04 {
    public static void main(String[] args) throws InterruptedException {
        final Object monitor = new Object();
        new Thread(() -> {
            while (true) {
                synchronized (monitor) {
                    System.out.println("+A");
                    System.out.println("-A");
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                synchronized (monitor) {

                    System.out.println("+B");
                    System.out.println("-B");
                }
            }
        }).start();
    }
}
