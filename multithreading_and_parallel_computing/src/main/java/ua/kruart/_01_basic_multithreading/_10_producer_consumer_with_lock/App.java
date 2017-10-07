package ua.kruart._01_basic_multithreading._10_producer_consumer_with_lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by kruart on 07.10.2017.
 */
public class App {

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        Thread t1 = new Thread(() -> worker.producer());
        Thread t2 = new Thread(() -> worker.consumer());
        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }
}

class Worker {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void producer() {
        lock.lock();
        try {
            System.out.println("Producer method ...");
            condition.await();
            System.out.println("Producer again...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    public void consumer() {

        try {
            Thread.sleep(2000);
            lock.lock();

            System.out.println("Consumer method ...");
            condition.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
