package net.golovach._2_juc._0_monitor_mid;

/**
 * Created by kruart on 29.09.2017.
 */
public class Consumer implements Runnable {

    private final int id;
    private final SingleElementBuffer buffer;

    public Consumer(int id, SingleElementBuffer buffer) {
        this.id = id;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer elem = buffer.get();
                System.out.println(" " + System.currentTimeMillis() + ": " + elem + " consumed by C#" + id);
            } catch (InterruptedException e) {/*NOP*/}
        }
    }
}
