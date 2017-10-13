package ua.kruart.chapter01_thread_management.recipe07_UncaughtExceptionHandler;

/**
 * Main class of the example. Initialize a Thread to process the uncaught
 * exceptions and starts a Task object that always throws an exception
 *
 */
public class Main {

    /**
     * Main method of the example. Initialize a Thread to process the uncaught
     * exceptions and starts a Task object that always throws an exception
     *
     * @param args
     */
    public static void main(String[] args) {

        Task task = new Task(); // Creates the Task
        Thread thread = new Thread(task); // Creates the Thread

        thread.setUncaughtExceptionHandler(new ExceptionHandler());  // Sets de uncaught exception handler
        thread.start(); // Starts the Thread

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Thread has finished\n");

    }

}
