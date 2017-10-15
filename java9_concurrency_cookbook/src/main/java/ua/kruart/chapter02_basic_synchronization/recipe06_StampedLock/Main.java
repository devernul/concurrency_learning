package ua.kruart.chapter02_basic_synchronization.recipe06_StampedLock;

import ua.kruart.chapter02_basic_synchronization.recipe06_StampedLock.task.OptimisticReader;
import ua.kruart.chapter02_basic_synchronization.recipe06_StampedLock.task.Position;
import ua.kruart.chapter02_basic_synchronization.recipe06_StampedLock.task.Reader;
import ua.kruart.chapter02_basic_synchronization.recipe06_StampedLock.task.Writer;

import java.util.concurrent.locks.StampedLock;

/**
 * Created by kruart on 15.10.2017.
 */
public class Main {

    public static void main(String[] args) {

        Position position = new Position();
        StampedLock lock = new StampedLock();

        Thread threadWriter = new Thread(new Writer(position, lock));
        Thread threadReader = new Thread(new Reader(position, lock));
        Thread threadOptReader = new Thread(new OptimisticReader(position, lock));

        threadWriter.start();
        threadReader.start();
        threadOptReader.start();

        try {
            threadWriter.join();
            threadReader.join();
            threadOptReader.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
