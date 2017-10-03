package net.golovach._2_juc._4_atomics;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by kruart on 03.10.2017.
 */
public class AtomicCounter {
    private final AtomicInteger value = new AtomicInteger(0);

    public int getValue(){
        return value.get();
    }

    public int getNextValue(){
        return value.incrementAndGet();
    }

    public int getPreviousValue(){
        return value.decrementAndGet();
    }

    public static void main(String[] args) {
        AtomicCounter atomicCounter = new AtomicCounter();
        System.out.println(atomicCounter.getValue());
        System.out.println(atomicCounter.getPreviousValue());
        System.out.println(atomicCounter.getNextValue());
        System.out.println(atomicCounter.getNextValue());
    }
}
