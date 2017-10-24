package ua.kruart.chapter08_customizing_concurrency_classes.recipe06_ThreadFactory_fork_join;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;

/**
 * Factory to be used by the Fork/Join framework to create the worker threads. Implements
 * the ForkJoinWorkerThreadFactory interface
 */
public class MyWorkerThreadFactory implements ForkJoinPool.ForkJoinWorkerThreadFactory {

    /**
     * Method that creates a worker thread for the Fork/Join framework
     * @param pool ForkJoinPool where the thread will be executed
     * @return a MyWorkerThread thread
     */
    @Override
    public ForkJoinWorkerThread newThread(ForkJoinPool pool) {
        return new MyWorkerThread(pool);
    }

}
