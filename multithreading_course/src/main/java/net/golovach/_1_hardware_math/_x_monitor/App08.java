package net.golovach._1_hardware_math._x_monitor;

/**
 * Created by kruart on 28.09.2017.
 */
public class App08 {
    private static volatile boolean in = false;

    public static void main(String[] args) throws InterruptedException {
        final Object monitor = new Object();
        new Thread(() -> {
            synchronized (monitor) {
                in = true;
                try {
                    System.out.println("X");
                    monitor.wait();
                    System.out.println("Y");
                } catch (InterruptedException e) {/*NOP*/}
            }
        }).start();

        System.out.println("A");
        while(!in); //spin lock / busy waiting
        System.out.println("B");
        synchronized (monitor) {
            System.out.println("C");
            monitor.notify();
        }
        System.out.println("D");
    }
}
