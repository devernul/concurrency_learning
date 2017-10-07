package ua.kruart._01_basic_multithreading._08_producer_consumer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kruart on 07.10.2017.
 */
public class App {
    static Processor processor = new Processor();
    public static void main(String[] args) {
        new Thread(() -> processor.producer()).start();
        new Thread(() -> processor.consumer()).start();
    }
}

class Processor {

    private List<Integer> list = new ArrayList<>();
    private final int LIMIT = 5;
    private final int BOTTOM = 0;
    private final Object lock = new Object();
    private int value = 0;

    public void producer() {
        synchronized (lock) {
            while (true) {
                try {
                    if (list.size() == LIMIT) {
                        System.out.println("Waiting for removing items from the list...");
                        lock.wait();
                    } else {
                        System.out.println("Adding: " + value);
                        list.add(value++);
                        lock.notify();
                    }

                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void consumer() {
        synchronized (lock) {
            while (true) {
                try {
                    if (list.size() == BOTTOM) {
                        System.out.println("Waiting for adding items to the list...");

                        lock.wait();
                    } else {
                        System.out.println("Removed: " + list.remove(--value));
                        lock.notify();
                    }

                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
