package net.golovach._4_akka._2_console_up_routed;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.routing.SmallestMailboxPool;
import net.golovach._4_akka.Callback;

import java.util.Scanner;

/**
 * Created by kruart on 05.10.2017.
 */
public class AppUpRouted {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("demo");
        ActorRef router = system.actorOf(new SmallestMailboxPool(5).props(Props.create(WorkerUpRouted.class)), "workers");
        ActorRef callback = system.actorOf(Props.create(Callback.class), "callback");

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            if ("exit".equals(line)) {
                system.terminate();
                return;
            }
            router.tell(line, callback);

        }
    }
}
