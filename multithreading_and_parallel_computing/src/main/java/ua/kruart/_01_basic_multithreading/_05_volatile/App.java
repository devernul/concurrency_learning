package ua.kruart._01_basic_multithreading._05_volatile;

/**
 * Created by kruart on 07.10.2017.
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        new Thread(worker).start();

        Thread.sleep(3000);

        worker.setTerminated(true);
        System.out.println("Finished...");
    }
}

class Worker implements Runnable {
    private volatile boolean isTerminated = false;

    @Override
    public void run() {
        while (!isTerminated) {
            System.out.println("Hello from Worker class...");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isTerminated() {
        return isTerminated;
    }

    public void setTerminated(boolean terminated) {
        isTerminated = terminated;
    }
}
