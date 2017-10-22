package ua.kruart.chapter06_parallel_and_reactive_streams.recipe09_reactive_streams.consumers;

import ua.kruart.chapter06_parallel_and_reactive_streams.recipe09_reactive_streams.items.Item;

import java.util.concurrent.Flow;

/**
 * Created by kruart on 22.10.2017.
 */
public class Consumer3 implements Flow.Subscriber<Item> {

    @Override
    public void onComplete() {
        System.out.printf("%s: Consumer 3: Completed\n", Thread.currentThread().getName());

    }

    @Override
    public void onError(Throwable exception) {
        System.out.printf("%s: Consumer 3: Error\n", Thread.currentThread().getName());
        exception.printStackTrace(System.err);
    }

    @Override
    public void onNext(Item item) {
        System.out.printf("%s: Consumer 3: Item received\n", Thread.currentThread().getName());
        System.out.printf("%s: Consumer 3: %s\n", Thread.currentThread().getName(),item.getTitle());
        System.out.printf("%s: Consumer 3: %s\n", Thread.currentThread().getName(), item.getContent());
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.printf("%s: Consumer 3: Subscription received\n", Thread.currentThread().getName());
        System.out.printf("%s: Consumer 3: Requested three items\n", Thread.currentThread().getName());
        subscription.request(3);
    }

}
