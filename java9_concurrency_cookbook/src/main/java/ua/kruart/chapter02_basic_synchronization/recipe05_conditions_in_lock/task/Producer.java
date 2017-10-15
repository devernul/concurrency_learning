package ua.kruart.chapter02_basic_synchronization.recipe05_conditions_in_lock.task;

import ua.kruart.chapter02_basic_synchronization.recipe05_conditions_in_lock.utils.FileMock;

/**
 * This class gets lines from the simulate file and stores them in the buffer,
 * if there is space in it.
 *
 */
public class Producer implements Runnable {

    /**
     * Simulated File
     */
    private FileMock mock;

    /**
     * Buffer
     */
    private Buffer buffer;

    /**
     * Constructor of the class. Initialize the objects
     *
     * @param mock
     *            Simulated file
     * @param buffer
     *            Buffer
     */
    public Producer(FileMock mock, Buffer buffer) {
        this.mock = mock;
        this.buffer = buffer;
    }

    /**
     * Core method of the producer. While are pending lines in the simulated
     * file, reads one and try to store it in the buffer.
     */
    @Override
    public void run() {
        buffer.setPendingLines(true);
        while (mock.hasMoreLines()) {
            String line = mock.getLine();
            buffer.insert(line);
        }
        buffer.setPendingLines(false);
    }

}
