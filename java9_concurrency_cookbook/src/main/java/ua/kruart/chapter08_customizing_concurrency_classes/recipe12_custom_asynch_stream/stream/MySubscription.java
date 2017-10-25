package ua.kruart.chapter08_customizing_concurrency_classes.recipe12_custom_asynch_stream.stream;

import java.util.concurrent.Flow;

/**
 * Created by kruart on 25.10.2017.
 */
public class MySubscription implements Flow.Subscription {

    private boolean canceled = false;
    private long requested = 0;

    @Override
    public void cancel() {
        canceled = true;
    }

    @Override
    public void request(long value) {
        requested += value;
    }

    /**
     * @return the canceled
     */
    public boolean isCanceled() {
        return canceled;
    }

    /**
     * @return the requested
     */
    public long getRequested() {
        return requested;
    }

    public void decreaseRequested() {
        requested--;
    }
}
