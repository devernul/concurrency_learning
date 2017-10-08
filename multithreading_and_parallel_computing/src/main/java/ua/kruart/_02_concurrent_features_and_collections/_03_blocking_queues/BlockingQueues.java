package ua.kruart._02_concurrent_features_and_collections._03_blocking_queues;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 
 * 	BlockingQueue -> an interface that represents a queue that is thread safe
 * 		Put items or take items from it ...
 * 
 * 		For example: one thread putting items into the queue and another thread taking items from it
 * 			at the same time !!!
 * 				We can do it with producer-consumer pattern !!!
 * 
 * 		put() putting items to the queue
 * 		take() taking items from the queue
 * 
 */

class FirstWorker implements Runnable {

	private BlockingQueue<String> blockingQueue;
	
	public FirstWorker(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 20; i++) {
				blockingQueue.put("A" + i);
				System.out.println("put A" + i);
				blockingQueue.put("B" + i);
				System.out.println("put B" + i);
				blockingQueue.put("C" + i);
				System.out.println("put C" + i);
			}
		} catch (InterruptedException e) {
            e.printStackTrace();
        }	
	}
}

class SecondWorker implements Runnable {

	private BlockingQueue<String> blockingQueue;
	
	public SecondWorker(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i < 20; i++) {
				System.out.println("take " + blockingQueue.take());
				Thread.sleep(700);
				System.out.println("take " + blockingQueue.take());
				System.out.println("take " + blockingQueue.take());
			}
		} catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
}

public class BlockingQueues {

	public static void main(String[] args) {
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(4);

		FirstWorker firstWorker = new FirstWorker(queue);
		SecondWorker secondWorker = new SecondWorker(queue);

        new Thread(firstWorker).start();
        new Thread(secondWorker).start();
	}
}
