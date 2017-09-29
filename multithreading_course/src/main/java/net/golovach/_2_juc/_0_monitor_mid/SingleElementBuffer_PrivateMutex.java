package net.golovach._2_juc._0_monitor_mid;

/**
 * Created by kruart on 29.09.2017.
 */
public class SingleElementBuffer_PrivateMutex {
    private final Object lock = new Object();
    private Integer elem = null;

    public void put(int newElem) throws InterruptedException {
        synchronized (lock) {
            while (this.elem != null) {
                this.wait();
            }

            this.elem = newElem;
            lock.notifyAll();
        }
    }

    public int get() throws InterruptedException {
        synchronized (lock) {
            while (this.elem == null) {
                this.wait();
            }

            Integer result = this.elem;
            this.elem = null;
            lock.notifyAll();
            return result;
        }
    }
}
