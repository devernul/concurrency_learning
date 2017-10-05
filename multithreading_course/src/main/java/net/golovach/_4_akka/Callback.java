package net.golovach._4_akka;

import akka.actor.UntypedAbstractActor;

import java.util.Arrays;

/**
 * Created by kruart on 05.10.2017.
 */
public class Callback extends UntypedAbstractActor {
    @Override
    public void onReceive(Object msg) throws Throwable {
        if (msg instanceof Object[]) {
            System.out.println("result: " + Arrays.toString((Object[]) msg));
        } else {
            System.out.println("result: " + msg);
        }
    }
}
