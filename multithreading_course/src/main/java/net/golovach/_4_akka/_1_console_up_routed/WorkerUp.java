package net.golovach._4_akka._1_console_up_routed;

import akka.actor.ActorRef;
import akka.actor.UntypedAbstractActor;

/**
 * Created by kruart on 05.10.2017.
 */
public class WorkerUp extends UntypedAbstractActor {

    @Override
    public void onReceive(Object msg) throws Throwable {
        if (msg instanceof String) {
            String response = ((String) msg).toUpperCase();
            ActorRef sender = getSender();
            sender.tell(response, getSender());
        } else {
            unhandled(msg);
        }
    }
}
