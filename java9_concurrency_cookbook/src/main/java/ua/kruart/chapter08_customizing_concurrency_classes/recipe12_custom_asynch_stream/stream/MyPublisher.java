package ua.kruart.chapter08_customizing_concurrency_classes.recipe12_custom_asynch_stream.stream;

import ua.kruart.chapter08_customizing_concurrency_classes.recipe12_custom_asynch_stream.data.News;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by kruart on 25.10.2017.
 */
public class MyPublisher implements Flow.Publisher<News> {

    private ConcurrentLinkedDeque<ConsumerData> consumers;
    private ThreadPoolExecutor executor;

    public MyPublisher() {
        consumers = new ConcurrentLinkedDeque<>();
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    @Override
    public void subscribe(Flow.Subscriber<? super News> subscriber) {

        ConsumerData consumerData = new ConsumerData();
        consumerData.setConsumer((Consumer)subscriber);

        MySubscription subscription = new MySubscription();
        consumerData.setSubscription(subscription);

        subscriber.onSubscribe(subscription);

        consumers.add(consumerData);
    }

    public void publish(News news) {
        consumers.forEach( consumerData -> {
            try {
                executor.execute(new PublisherTask(consumerData, news));
            } catch (Exception e) {
                consumerData.getConsumer().onError(e);
            }
        });
    }

}
