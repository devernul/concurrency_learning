package ua.kruart.chapter08_customizing_concurrency_classes.recipe03_impl_ThreadFactory_Thread;

import java.util.Date;

/**
 * This class extends the Thread class calculating its execution time
 *
 */
public class MyThread extends Thread {

    /**
     * Creation date of the Thread
     */
    private final Date creationDate;

    /**
     * Start date of the Thread
     */
    private Date startDate;

    /**
     * Finish date of the Thread
     */
    private Date finishDate;

    /**
     * Constructor of the class. Use the constructor of the Thread class and storeas the creation date of the Thread
     * @param target Task to execute
     * @param name Name of the thread
     */
    public MyThread(Runnable target, String name) {
        super(target, name);
        creationDate = new Date();
    }

    /**
     * Main method of the thread. Stores the start date and the finish date and calls the run() method of the parent class
     */
    @Override
    public void run() {
        setStartDate();
        super.run();
        setFinishDate();
    }


    /**
     * Method that establish the value of the start date
     */
    public synchronized void setStartDate() {
        startDate = new Date();
    }

    /**
     * Method that establish the value of the finish date
     */
    public synchronized void setFinishDate() {
        finishDate = new Date();
    }

    /**
     * Method that calculates the execution time of the thread
     * @return The execution time of the thread
     */
    public synchronized long getExecutionTime() {
        return finishDate.getTime() - startDate.getTime();
    }

    /**
     * Method that writes information about the thread
     */
    @Override
    public synchronized String toString(){
        StringBuilder buffer = new StringBuilder(getName())
                .append(": ")
                .append(" Creation Date: ")
                .append(creationDate)
                .append(" : Running time: ")
                .append(getExecutionTime())
                .append(" Milliseconds.");
        return buffer.toString();
    }
}
