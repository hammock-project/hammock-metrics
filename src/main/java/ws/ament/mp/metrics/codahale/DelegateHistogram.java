package ws.ament.mp.metrics.codahale;

import com.codahale.metrics.Histogram;
import com.codahale.metrics.Snapshot;

public class DelegateHistogram extends Histogram {

    private final org.eclipse.microprofile.metrics.Histogram delegate;

    public DelegateHistogram(org.eclipse.microprofile.metrics.Histogram delegate) {
        super(null);
        this.delegate = delegate;
    }

    @Override
    public void update(int i) {
        delegate.update(i);
    }

    @Override
    public void update(long l) {
        delegate.update(l);
    }

    @Override
    public long getCount() {
        return delegate.getCount();
    }

    @Override
    public Snapshot getSnapshot() {
        return new DelegateSnapshot(delegate.getSnapshot());
    }
}
