package net.golovach._2_juc._0_monitor_mid;

/**
 * Created by kruart on 29.09.2017.
 */
public class ProducerConsumerExample_3x1x2 {
    public static void main(String[] args) {
        SingleElementBuffer buffer = new SingleElementBuffer();

        new Thread(new Producer(1, 1, 300, buffer)).start();
        new Thread(new Producer(2, 100, 500, buffer)).start();
        new Thread(new Producer(3, 1000, 700, buffer)).start();

        new Thread(new Consumer(1, buffer)).start();
        new Thread(new Consumer(2, buffer)).start();
    }
}
