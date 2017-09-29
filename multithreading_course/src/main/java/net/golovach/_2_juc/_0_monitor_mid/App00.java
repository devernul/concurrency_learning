package net.golovach._2_juc._0_monitor_mid;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by kruart on 29.09.2017.
 */
//Producers/Consumers
public class App00 {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(16);

        //Producer
        new Thread(() -> {
            int counter = 0;
            while (true) {
                try {
                    Thread.sleep(10);
                    queue.put(++counter);
                    System.out.println("put: " + counter);
                } catch (InterruptedException ignore) {/*NOP*/}
            }
        }).start();

        //Consumer
        new Thread(() -> {
            while (true) {
                try {
                    int data = queue.take();        //block thread
//                    int data = queue.poll();      //null
//                    int data = queue.remove();    //NoSuckElementException
                    System.out.println("take: " + data);
                } catch (InterruptedException ignore) {/*NOP*/}
            }
        }).start();
    }
}
