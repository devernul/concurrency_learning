package ua.kruart.chapter01_thread_management.recipe08_threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * UnsafeMain class of the UnsafeTask. Creates a Runnable task and three Thread
 * objects that run it.
 *
 */
public class UnsafeMain {
    public static void main(String[] args) {
        // Creates the unsafe task
        UnsafeTask task = new UnsafeTask();

        // Throw ten Thread objects
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(task);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
