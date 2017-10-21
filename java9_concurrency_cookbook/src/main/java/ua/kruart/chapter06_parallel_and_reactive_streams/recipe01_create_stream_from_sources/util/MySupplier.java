package ua.kruart.chapter06_parallel_and_reactive_streams.recipe01_create_stream_from_sources.util;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

public class MySupplier implements Supplier<String> {

    private final AtomicInteger counter;

    public MySupplier() {
        counter = new AtomicInteger(0);
    }

    @Override
    public String get() {
        int value = counter.getAndAdd(1);
        return "String " + value;
    }

}
