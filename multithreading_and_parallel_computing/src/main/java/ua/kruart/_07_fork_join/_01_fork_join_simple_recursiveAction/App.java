package ua.kruart._07_fork_join._01_fork_join_simple_recursiveAction;

import java.util.concurrent.ForkJoinPool;

/**
 * fork() asynchronously execute the given task in the pool
 * 			We can call this on RecursiveAction or RevursiveTask<T>
 *
 * join() returns the result of the computation when it is done
 *
 * invoke() execute the given task + return its result upon completion
 * */
public class App {

	public static void main(String[] args) {
		
		ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		SimpleRecursiveAction simpleRecursiveAction = new SimpleRecursiveAction(400);
		forkJoinPool.invoke(simpleRecursiveAction);
	}
}
