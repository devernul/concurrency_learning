package ua.kruart.chapter08_customizing_concurrency_classes.recipe12_custom_asynch_stream.stream;

/**
 * Created by kruart on 25.10.2017.
 */
public class ConsumerData {

    private Consumer consumer;
    private MySubscription subscription;
    /**
     * @return the consumer
     */
    public Consumer getConsumer() {
        return consumer;
    }
    /**
     * @param consumer the consumer to set
     */
    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }
    /**
     * @return the subscription
     */
    public MySubscription getSubscription() {
        return subscription;
    }
    /**
     * @param subscription the subscription to set
     */
    public void setSubscription(MySubscription subscription) {
        this.subscription = subscription;
    }
}
