package net.golovach._1_hardware_math._2_jmm._1_stop_flag;

/**
 * Created by kruart on 26.09.2017.
 */
//JMM = java memory model
public class App00_norm {
    private static int data = 0;
    private static boolean isRun = true; //non-deterministic, because sharing data in some threads
//    private volatile static boolean isRun = true; //if volatile program works right

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (isRun) ; //0.. inf
            System.out.println("Bye");
        }).start();

        Thread.sleep(10);
        isRun = false;
    }
}
