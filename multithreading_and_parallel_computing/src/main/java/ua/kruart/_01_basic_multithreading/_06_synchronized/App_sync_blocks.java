package ua.kruart._01_basic_multithreading._06_synchronized;

/**
 * Created by kruart on 07.10.2017.
 */
public class App_sync_blocks {
    private static int counter1 = 0;
    private static int counter2 = 0;

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> compute());
        Thread t2 = new Thread(() -> compute());
        long a = System.currentTimeMillis();


        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(System.currentTimeMillis() - a);

        System.out.println("Counter1 = " + counter1 + " Counter2 = " + counter2);
    }

    public static void compute() {
        for (int i = 0; i < 30_000_000; i++) {
            add();
            addAgain();
        }
    }

    private static int add() {
//        synchronized (App_sync_blocks.class) { //it's faster
        synchronized (lock1) {
            return counter1++;
        }
    }

    private static int addAgain() {
//        synchronized (App_sync_blocks.class) { //it's faster
        synchronized (lock2) {
            return counter2++;
        }
    }
}
