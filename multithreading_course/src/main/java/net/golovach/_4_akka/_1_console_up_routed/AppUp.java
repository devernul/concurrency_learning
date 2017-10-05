package net.golovach._4_akka._1_console_up_routed;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import net.golovach._4_akka.Callback;

import java.util.Scanner;

/**
 * Created by kruart on 05.10.2017.
 */
public class AppUp {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("demo");
        ActorRef worker = system.actorOf(Props.create(WorkerUp.class), "worker");
        ActorRef callback = system.actorOf(Props.create(Callback.class), "callback");

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            if ("exit".equals(line)) {
                system.terminate();
                return;
            }
            worker.tell(line, callback);
//            worker.tell(line, ActorRef.noSender()); //"null object" patterns
        }
    }
}
