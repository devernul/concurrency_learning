package net.golovach._2_juc._0_monitor_mid;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by kruart on 29.09.2017.
 */
//Producers/Consumers
public class App01 {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(16);

        //Producers
        for (int i = 0; i < 3; i++) {
            int finakI = i;
            new Thread(() -> {
                int counter = 0;
                while (true) {
                    try {
                        Thread.sleep(250 + 1000 * finakI);
                        String data = "elem-" + finakI + " #" + ++counter;
                        queue.put(data);
                        System.out.println("put: " + data);
                    } catch (InterruptedException ignore) {/*NOP*/}
                }
            }).start();
        }

        //Consumer
        new Thread(() -> {
            while (true) {
                try {
                    String data = queue.take();        //block thread
//                    int data = queue.poll();      //null
//                    int data = queue.remove();    //NoSuckElementException
                    System.out.println("take: " + data);
                } catch (InterruptedException ignore) {/*NOP*/}
            }
        }).start();
    }
}
