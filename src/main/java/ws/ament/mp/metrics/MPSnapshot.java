package ws.ament.mp.metrics;

import org.eclipse.microprofile.metrics.Snapshot;

import java.io.OutputStream;

public class MPSnapshot extends Snapshot {
    private final com.codahale.metrics.Snapshot delegate;

    MPSnapshot(com.codahale.metrics.Snapshot delegate) {
        this.delegate = delegate;
    }
    public double getValue(double v) {
        return delegate.getValue(v);
    }

    public long[] getValues() {
        return delegate.getValues();
    }

    public int size() {
        return delegate.size();
    }

    public long getMax() {
        return delegate.getMax();
    }

    public double getMean() {
        return delegate.getMean();
    }

    public long getMin() {
        return delegate.getMin();
    }

    public double getStdDev() {
        return delegate.getStdDev();
    }

    public void dump(OutputStream outputStream) {
        delegate.dump(outputStream);
    }

}
