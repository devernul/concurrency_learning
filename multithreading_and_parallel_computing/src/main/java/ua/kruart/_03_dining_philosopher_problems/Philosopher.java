package ua.kruart._03_dining_philosopher_problems;

import java.util.Random;

/**
 * Created by kruart on 08.10.2017.
 */
public class Philosopher implements Runnable {
    private int id;
    private ChopStick leftChopStick;
    private ChopStick rightChopStick;
    private Random random;
    private int eatingCounter;
    private volatile boolean isFull = false;

    public Philosopher(int id, ChopStick leftChopStick, ChopStick rightChopStick){
        this.id = id;
        this.leftChopStick = leftChopStick;
        this.rightChopStick = rightChopStick;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            while (!isFull) {
                think();

                if (leftChopStick.pickUp(this, State.LEFT)) {
                    if( rightChopStick.pickUp(this, State.RIGHT)) {
                        eat();
                        rightChopStick.putDown(this, State.RIGHT);
                    }
                    leftChopStick.putDown(this, State.LEFT);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void think() throws InterruptedException {
        System.out.println(this + " is thinking...");
        Thread.sleep(random.nextInt(1000));
    }

    private void eat() throws InterruptedException {
        System.out.println(this + " is eating...");
        this.eatingCounter++;
        Thread.sleep(random.nextInt(1000));
    }

    public int getEatingCounter() {
        return eatingCounter;
    }

    public void setFull(boolean isFull) {
        this.isFull = isFull;
    }

    @Override
    public String toString() {
        return "Philosopher{id=" + id + '}';
    }
}
