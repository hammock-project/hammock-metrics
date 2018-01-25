package ws.ament.mp.metrics;

import com.codahale.metrics.Metric;

public interface MPDropwizard<T extends Metric> {
    T getDelegate();
}
