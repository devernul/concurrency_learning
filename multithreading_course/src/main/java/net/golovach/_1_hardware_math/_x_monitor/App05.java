package net.golovach._1_hardware_math._x_monitor;

/**
 * Created by kruart on 28.09.2017.
 */
public class App05 {
    private static volatile boolean in = false;

    public static void main(String[] args) throws InterruptedException {
        final Object monitor = new Object();
        new Thread(() -> {
            synchronized (monitor) {
                in = true;
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {/*NOP*/}
            }
        }).start();

        System.out.println("A");
        while(!in); //spin lock / busy waiting
        System.out.println("B");
        synchronized (monitor) {System.out.println("C"); }
    }
}
