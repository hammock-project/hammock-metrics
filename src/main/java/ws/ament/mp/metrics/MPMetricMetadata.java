package ws.ament.mp.metrics;

import org.eclipse.microprofile.metrics.Metadata;
import org.eclipse.microprofile.metrics.Metric;

public class MPMetricMetadata {
    private final Metadata metadata;
    private final Metric metric;

    public MPMetricMetadata(Metadata metadata, Metric metric) {
        this.metadata = metadata;
        this.metric = metric;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public Metric getMetric() {
        return metric;
    }
}
