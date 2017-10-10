package ua.kruart._07_fork_join._02_fork_join_simple_recursiveTask;

import java.util.concurrent.RecursiveTask;

public class SimpleRecursiveTask extends RecursiveTask<Integer> {

	private int simulatedWork;
	
	public SimpleRecursiveTask(int simulatedWork) {
		this.simulatedWork = simulatedWork;
	}
	
	@Override
	protected Integer compute() {
		if(simulatedWork > 100) {
			System.out.println("Parallel execution and split the tasks..." + simulatedWork);
			
			SimpleRecursiveTask task1 = new SimpleRecursiveTask(simulatedWork / 2);
			SimpleRecursiveTask task2 = new SimpleRecursiveTask(simulatedWork / 2);
			
			task1.fork();
			task2.fork();
			
			int solution = 0;
			solution += task1.join();
			solution += task2.join();
			
			return solution;
			
		} else {
			System.out.println("No need for parallel execution, sequential is OK for this task..." );
			return 2 * simulatedWork;
		}
	}
}
