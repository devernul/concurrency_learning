package ua.kruart.chapter10_additional_info.recipe02_process_uncontrol_exception_in_FJP;

import ua.kruart.chapter10_additional_info.recipe02_process_uncontrol_exception_in_FJP.task.AlwaysThrowsExceptionWorkerThreadFactory;
import ua.kruart.chapter10_additional_info.recipe02_process_uncontrol_exception_in_FJP.task.Handler;
import ua.kruart.chapter10_additional_info.recipe02_process_uncontrol_exception_in_FJP.task.OneSecondLongTask;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Main class of the example
 */
public class Main {
	public static void main(String[] args) {

		// Creates a task
		OneSecondLongTask task = new OneSecondLongTask();
		
		// Creates a new Handler
		Handler handler = new Handler();
		// Creates a Factory
		AlwaysThrowsExceptionWorkerThreadFactory factory = new AlwaysThrowsExceptionWorkerThreadFactory();
		// Creates a new ForkJoinPool
		ForkJoinPool pool = new ForkJoinPool(2, factory, handler, false);
		
		// Execute the task in the pool
		pool.execute(task);
	
		// Shutdown the pool
		pool.shutdown();
		
		// Wait for the finalization of the tasks
		try {
			pool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Main: The program has finished.\n");
		
	}

}
