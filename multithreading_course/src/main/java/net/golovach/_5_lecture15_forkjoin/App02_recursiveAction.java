package net.golovach._5_lecture15_forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by kruart on 06.10.2017.
 */
public class App02_recursiveAction {
    public static void main(String[] args) throws InterruptedException {
        long a = System.currentTimeMillis();
        long result = new ForkJoinPool().invoke(new Task(0, 1_000_000));
        System.out.println(System.currentTimeMillis() - a);
        System.out.println(result);

    }
    public static class Task extends RecursiveTask<Long> {
        private final int from;
        private final int to;

        public Task(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if (to - from < 10_000) {
                return directCalc();
            } else {
                int mid = (from + to) >>> 1;
                Task taskLeft = new Task(from, mid);
                Task taskRight = new Task(mid, to);
                taskLeft.fork();
                taskRight.fork();
                return taskLeft.join() + taskRight.join();
            }
        }

        private long directCalc() {
            long result = 0;
            for (int index = from; index < to; index++) {
                if (index % 3 != 0 && index % 5 != 0) {
                    result += index;
                }
            }
            return result;
        }
    }
}
