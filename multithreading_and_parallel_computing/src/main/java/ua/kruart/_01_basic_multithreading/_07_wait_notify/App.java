package ua.kruart._01_basic_multithreading._07_wait_notify;

/**
 * Created by kruart on 07.10.2017.
 */
public class App {
    public static void main(String[] args) {
        Processor processor = new Processor();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                processor.produce();
            } }).start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                processor.consume();
            }}).start();
    }
}

class Processor {
    public void produce() {
        synchronized (this) {
            System.out.println("We are in the producer method...");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Again producer method");
        }
    }

    public void consume() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this) {
            System.out.println("We are in the consume method...");
            notify();
        }
    }
}
