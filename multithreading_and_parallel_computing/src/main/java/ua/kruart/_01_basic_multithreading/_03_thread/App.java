package ua.kruart._01_basic_multithreading._03_thread;

/**
 * Created by kruart on 07.10.2017.
 */
public class App {
    public static void main(String[] args) {
        new Runner1().start();
        new Runner2().start();
    }
}

class Runner1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Runner1: " + i);
        }
    }
}

class Runner2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Runner2: " + i);
        }
    }
}
