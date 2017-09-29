package net.golovach._2_juc._0_monitor_mid;

/**
 * Created by kruart on 29.09.2017.
 */
public class SingleElementBuffer {
    private Integer elem = null;

    public synchronized void put(int newElem) throws InterruptedException {
        while (this.elem != null) {
            this.wait();
        }

        this.elem = newElem;
        this.notifyAll();
    }

    public synchronized int get() throws InterruptedException {
        while (this.elem == null) {
            this.wait();
        }

        Integer result = this.elem;
        this.elem = null;
        this.notifyAll();
        return result;
    }
}

class T {
    public static void main(String[] args) {
        final ThreadGroup group = new ThreadGroup("stub");
        Thread.UncaughtExceptionHandler exceptionHandler = (t, e) -> group.interrupt();

        Thread p0 = new Thread(group, () -> {
            try {
                Thread.sleep(Long.MAX_VALUE);
            } catch (InterruptedException e) {
                System.out.println("0 - killed");
            }
        });
        p0.setUncaughtExceptionHandler(exceptionHandler);
        p0.start();

        Thread p1 = new Thread(group, () -> {
            System.out.println("1 - dead");
            throw new Error();
        });
        p1.setUncaughtExceptionHandler(exceptionHandler);
        p1.start();
    }
}
