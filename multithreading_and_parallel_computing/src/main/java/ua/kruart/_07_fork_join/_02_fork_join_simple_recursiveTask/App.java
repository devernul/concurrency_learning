package ua.kruart._07_fork_join._02_fork_join_simple_recursiveTask;

import java.util.concurrent.ForkJoinPool;

public class App {
	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		SimpleRecursiveTask simpleRecursiveAction = new SimpleRecursiveTask(120);
		System.out.println(forkJoinPool.invoke(simpleRecursiveAction));
	}
}
