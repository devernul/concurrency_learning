package ua.kruart.chapter07_concurrent_collections.recipe09_volatile.task;

import ua.kruart.chapter07_concurrent_collections.recipe09_volatile.data.Flag;

import java.util.Date;

public class Task implements Runnable {

    private Flag flag;

    public Task(Flag flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        int i = 0;
        while (flag.flag) {
            i++;
        }
        System.out.printf("Task: %d - %s\n", i, new Date());
    }

}
