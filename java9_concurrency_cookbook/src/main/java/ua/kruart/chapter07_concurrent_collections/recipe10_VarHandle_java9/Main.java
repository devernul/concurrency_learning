package ua.kruart.chapter07_concurrent_collections.recipe10_VarHandle_java9;

import ua.kruart.chapter07_concurrent_collections.recipe10_VarHandle_java9.data.Account;
import ua.kruart.chapter07_concurrent_collections.recipe10_VarHandle_java9.task.Decrementer;
import ua.kruart.chapter07_concurrent_collections.recipe10_VarHandle_java9.task.Incrementer;

/**
 * Created by kruart on 23.10.2017.
 */
public class Main {

    public static void main(String[] args) {

        Account account = new Account();

        Thread threadIncrementer = new Thread(new Incrementer(account));
        Thread threadDecrementer = new Thread(new Decrementer(account));

        threadIncrementer.start();
        threadDecrementer.start();

        try {
            threadIncrementer.join();
            threadDecrementer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Safe amount: %f\n", account.amount);
        System.out.printf("Unsafe amount: %f\n", account.unsafeAmount);

    }

}
