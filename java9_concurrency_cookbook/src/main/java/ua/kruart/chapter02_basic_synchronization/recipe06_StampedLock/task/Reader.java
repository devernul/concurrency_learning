package ua.kruart.chapter02_basic_synchronization.recipe06_StampedLock.task;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * Created by kruart on 15.10.2017.
 */
public class Reader implements Runnable {

    private final Position position;
    private final StampedLock lock;

    public Reader (Position position, StampedLock lock) {
        this.position = position;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            long stamp = lock.readLock();
            try {
                System.out.printf("Reader: %d - (%d,%d)\n", stamp, position.getX(), position.getY());
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlockRead(stamp);
                System.out.printf("Reader: %d - Lock released\n", stamp);
            }
        }
    }

}