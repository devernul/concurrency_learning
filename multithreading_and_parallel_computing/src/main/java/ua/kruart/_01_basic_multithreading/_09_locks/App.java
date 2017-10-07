package ua.kruart._01_basic_multithreading._09_locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by kruart on 07.10.2017.
 */
public class App {
    private static int counter = 0;
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> increment());
        Thread t2 = new Thread(() -> increment());
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter); //2_000_000
    }

    public static void increment() {
        lock.lock();
        try {
            for (int i = 0; i < 1_000_000; i++) {
                counter++;
            }
        } finally {
            lock.unlock();
        }
    }
}
