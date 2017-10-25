package ua.kruart.chapter08_customizing_concurrency_classes.recipe12_custom_asynch_stream.stream;

import ua.kruart.chapter08_customizing_concurrency_classes.recipe12_custom_asynch_stream.data.News;

/**
 * Created by kruart on 25.10.2017.
 */
public class PublisherTask implements Runnable {

    private ConsumerData consumerData;
    private News news;

    public PublisherTask(ConsumerData consumerData, News news) {
        this.consumerData = consumerData;
        this.news = news;
    }

    @Override
    public void run() {
        MySubscription subscription = consumerData.getSubscription();
        if (!(subscription.isCanceled() && (subscription.getRequested() > 0))) {
            consumerData.getConsumer().onNext(news);
            subscription.decreaseRequested();
        }
    }
}
