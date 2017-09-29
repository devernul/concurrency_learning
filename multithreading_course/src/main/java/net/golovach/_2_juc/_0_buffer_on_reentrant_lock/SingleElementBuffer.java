package net.golovach._2_juc._0_buffer_on_reentrant_lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by kruart on 29.09.2017.
 */
//1. fairness
//2. lock/unlock - independent
public class SingleElementBuffer {
    private Integer elem = null;
    private final Lock lock = new ReentrantLock(true);
    private final Condition notEmpty = lock.newCondition();
    private final Condition notFull = lock.newCondition();

    public void put(int newElem) throws InterruptedException {
        lock.lock();
        try {
            while (this.elem != null) {
                notFull.await();    //await not wait
            }
            this.elem = newElem;
            notEmpty.signal();      //signal not signalAll
        } finally {
            lock.unlock();
        }
    }

    public synchronized int get() throws InterruptedException {
        lock.lock();
        try {
            while (this.elem == null) {
                notEmpty.await();    //await not wait
            }
            Integer result = this.elem;
            this.elem = null;
            notFull.signal();       //signal not signalAll
            return result;
        } finally {
            lock.unlock();
        }


    }
}
