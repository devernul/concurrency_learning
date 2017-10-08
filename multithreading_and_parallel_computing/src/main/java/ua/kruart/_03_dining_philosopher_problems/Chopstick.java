package ua.kruart._03_dining_philosopher_problems;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by kruart on 08.10.2017.
 */
public class Chopstick {
    private int id;
    private Lock lock;

    public Chopstick(int id) {
        this.id = id;
        this.lock = new ReentrantLock();
    }

    public boolean pickUp(Philosopher philosopher, State state) throws InterruptedException {
       if (lock.tryLock(10, TimeUnit.MILLISECONDS))  {
           System.out.println(philosopher + " picked up " + state.toString() + " " + this);
           return true;
       }
       return false;
    }

    public void putDown(Philosopher philosopher, State state) {
        lock.unlock();
        System.out.println(philosopher + " put down " + this);
    }

    @Override
    public String toString() {
        return "ChopStick" + id;
    }
}
