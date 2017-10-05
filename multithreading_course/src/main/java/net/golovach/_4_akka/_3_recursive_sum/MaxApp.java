package net.golovach._4_akka._3_recursive_sum;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import net.golovach._4_akka.Callback;

/**
 * Created by kruart on 05.10.2017.
 */
public class MaxApp {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("demo");
        ActorRef callback = system.actorOf(Props.create(Callback.class), "callback");
        ActorRef kernel = system.actorOf(Props.create(SumKernel.class, callback), "sumKernel");

        // [0, 10] -> {1, 2, 4, 7, 8}/5
        // [0, 20] -> {1, 2, 4, 7, 8, 11, 13, 14, 16, 17, 19}/11
        kernel.tell(new int[] {0, 10}, ActorRef.noSender());

//        ExecutorService pool = Executors.newCachedThreadPool();
//        for (int k = 0; k < 25; k++) {
//            pool.execute(() -> {/*...*/});
//        }
    }
}
