package ua.kruart.chapter07_concurrent_collections.recipe10_VarHandle_java9.task;

import ua.kruart.chapter07_concurrent_collections.recipe10_VarHandle_java9.data.Account;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

/**
 * Created by kruart on 23.10.2017.
 */
public class Decrementer implements Runnable {

    private Account account;

    public Decrementer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        VarHandle handler;
        try {
            handler = MethodHandles.lookup().in(Account.class).findVarHandle(Account.class, "amount", double.class);
            for (int i = 0; i < 10000; i++) {
                handler.getAndAdd(account, -100);
                account.unsafeAmount -= 100;
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
