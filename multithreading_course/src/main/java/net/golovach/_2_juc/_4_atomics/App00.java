package net.golovach._2_juc._4_atomics;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by kruart on 03.10.2017.
 */
public class App00 {
    public static void main(String[] args) {
        AtomicReference<String> atomicStringReference = new AtomicReference<>("Start");
        System.out.println(atomicStringReference.get());

        String initialValue = "initial value referenced";
        atomicStringReference.set(initialValue);
        System.out.println(atomicStringReference.get());

        String newString = "new value referenced";
        System.out.println(atomicStringReference.compareAndSet(initialValue, newString));
        System.out.println(atomicStringReference.get());

    }
}
