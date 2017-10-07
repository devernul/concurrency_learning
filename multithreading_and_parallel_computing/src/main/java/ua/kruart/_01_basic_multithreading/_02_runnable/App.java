package ua.kruart._01_basic_multithreading._02_runnable;

/**
 * Created by kruart on 07.10.2017.
 */
public class App {
    public static void main(String[] args) {
        new Thread(new Runner1()).start();
        new Thread(new Runner2()).start();
    }
}

class Runner1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Runner1: " + i);
        }
    }
}

class Runner2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Runner2: " + i);
        }
    }
}
