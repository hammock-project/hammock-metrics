package ws.ament.mp.metrics;

import com.codahale.metrics.Histogram;
import org.eclipse.microprofile.metrics.Snapshot;

public class MPHistogram implements org.eclipse.microprofile.metrics.Histogram {
    private final Histogram delegate;

    public MPHistogram(Histogram delegate) {
        this.delegate = delegate;
    }

    public void update(int i) {
        this.delegate.update(i);
    }

    public void update(long l) {
        this.delegate.update(l);
    }

    public long getCount() {
        return this.delegate.getCount();
    }

    public Snapshot getSnapshot() {
        return new MPSnapshot(this.delegate.getSnapshot());
    }
}
