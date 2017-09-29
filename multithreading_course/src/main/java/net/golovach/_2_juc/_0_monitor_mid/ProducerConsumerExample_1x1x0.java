package net.golovach._2_juc._0_monitor_mid;

/**
 * Created by kruart on 29.09.2017.
 */
public class ProducerConsumerExample_1x1x0 {
    public static void main(String[] args) {
        SingleElementBuffer buffer = new SingleElementBuffer();

        new Thread(new Producer(1, 1, 300, buffer)).start();
    }
}
