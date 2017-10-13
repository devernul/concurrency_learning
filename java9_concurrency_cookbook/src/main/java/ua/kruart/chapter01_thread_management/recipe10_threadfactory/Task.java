package ua.kruart.chapter01_thread_management.recipe10_threadfactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by kruart on 13.10.2017.
 */
public class Task implements Runnable {

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
