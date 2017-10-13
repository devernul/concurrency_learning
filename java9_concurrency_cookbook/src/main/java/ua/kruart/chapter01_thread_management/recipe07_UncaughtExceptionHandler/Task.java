package ua.kruart.chapter01_thread_management.recipe07_UncaughtExceptionHandler;

/**
 * Runnable class than throws and Exception
 *
 */
public class Task implements Runnable {

    /**
     * Main method of the class
     */
    @Override
    public void run() {
        // The next instruction always throws and exception
        int number = Integer.parseInt("TTT");
        // This sentence will never be executed
        System.out.printf("Number: %d ", number);
    }

}
