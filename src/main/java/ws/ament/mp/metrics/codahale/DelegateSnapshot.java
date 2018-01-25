package ws.ament.mp.metrics.codahale;

import com.codahale.metrics.Snapshot;

import java.io.OutputStream;

public class DelegateSnapshot extends Snapshot {
    private final org.eclipse.microprofile.metrics.Snapshot delegate;

    public DelegateSnapshot(org.eclipse.microprofile.metrics.Snapshot delegate) {
        this.delegate = delegate;
    }

    @Override
    public double getValue(double v) {
        return delegate.getValue(v);
    }

    @Override
    public long[] getValues() {
        return delegate.getValues();
    }

    @Override
    public int size() {
        return delegate.size();
    }

    @Override
    public double getMedian() {
        return delegate.getMedian();
    }

    @Override
    public double get75thPercentile() {
        return delegate.get75thPercentile();
    }

    @Override
    public double get95thPercentile() {
        return delegate.get95thPercentile();
    }

    @Override
    public double get98thPercentile() {
        return delegate.get98thPercentile();
    }

    @Override
    public double get99thPercentile() {
        return delegate.get99thPercentile();
    }

    @Override
    public double get999thPercentile() {
        return delegate.get999thPercentile();
    }

    @Override
    public long getMax() {
        return delegate.getMax();
    }

    @Override
    public double getMean() {
        return delegate.getMean();
    }

    @Override
    public long getMin() {
        return delegate.getMin();
    }

    @Override
    public double getStdDev() {
        return delegate.getStdDev();
    }

    @Override
    public void dump(OutputStream outputStream) {
        delegate.dump(outputStream);
    }
}
