package ws.ament.mp.metrics.codahale;

import com.codahale.metrics.Meter;

public class DelegateMeter extends Meter {
    private final org.eclipse.microprofile.metrics.Meter delegate;

    public DelegateMeter(org.eclipse.microprofile.metrics.Meter delegate) {
        this.delegate = delegate;
    }

    @Override
    public void mark() {
        delegate.mark();
    }

    @Override
    public void mark(long l) {
        delegate.mark(l);
    }

    @Override
    public long getCount() {
        return delegate.getCount();
    }

    @Override
    public double getFifteenMinuteRate() {
        return delegate.getFifteenMinuteRate();
    }

    @Override
    public double getFiveMinuteRate() {
        return delegate.getFiveMinuteRate();
    }

    @Override
    public double getMeanRate() {
        return delegate.getMeanRate();
    }

    @Override
    public double getOneMinuteRate() {
        return delegate.getOneMinuteRate();
    }
}
