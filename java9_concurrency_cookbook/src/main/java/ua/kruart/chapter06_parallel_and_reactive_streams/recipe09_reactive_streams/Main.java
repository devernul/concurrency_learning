package ua.kruart.chapter06_parallel_and_reactive_streams.recipe09_reactive_streams;

import ua.kruart.chapter06_parallel_and_reactive_streams.recipe09_reactive_streams.consumers.Consumer1;
import ua.kruart.chapter06_parallel_and_reactive_streams.recipe09_reactive_streams.consumers.Consumer2;
import ua.kruart.chapter06_parallel_and_reactive_streams.recipe09_reactive_streams.consumers.Consumer3;
import ua.kruart.chapter06_parallel_and_reactive_streams.recipe09_reactive_streams.items.Item;

import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

/**
 * Created by kruart on 22.10.2017.
 */
public class Main {

    public static void main(String[] args) {

        Consumer1 consumer1 = new Consumer1();
        Consumer2 consumer2 = new Consumer2();
        Consumer3 consumer3 = new Consumer3();

        SubmissionPublisher<Item> publisher = new SubmissionPublisher<>();

        publisher.subscribe(consumer1);
        publisher.subscribe(consumer2);
        publisher.subscribe(consumer3);

        for (int i = 0; i < 10; i++) {
            Item item  = new Item();
            item.setTitle("Item " + i);
            item.setContent("This is the item " + i);
            publisher.submit(item);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        publisher.close();
    }

}
