package ua.kruart.chapter07_concurrent_collections.recipe10_VarHandle_java9.data;

/**
 * Created by kruart on 23.10.2017.
 */
public class Account {

    public double amount;

    public double unsafeAmount;

    public Account() {
        this.amount = 0;
        this.unsafeAmount = 0;
    }
}
