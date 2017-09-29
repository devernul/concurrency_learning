package net.golovach._2_juc._0_monitor_mid;

/**
 * Created by kruart on 29.09.2017.
 */
public class Producer implements Runnable {
    private final int id;
    private int value;
    private final int period;
    private final SingleElementBuffer buffer;

    public Producer(int id, int value, int period, SingleElementBuffer buffer) {
        this.id = id;
        this.value = value;
        this.period = period;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(System.currentTimeMillis() + ": " + value + " produced by P#" + id);
                buffer.put(value++);
                Thread.sleep(period);
            } catch (InterruptedException ignore) {/*NOP*/}
        }
    }
}
