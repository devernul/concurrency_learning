package ua.kruart.chapter06_parallel_and_reactive_streams.recipe03_collecting;

/**
 * Created by kruart on 22.10.2017.
 */
public class Counter {

    private String value;
    private int counter;

    public Counter() {
        counter = 1;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }
    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }
    /**
     * @return the counter
     */
    public int getCounter() {
        return counter;
    }
    /**
     * @param counter the counter to set
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void increment() {
        counter++;
    }

}
