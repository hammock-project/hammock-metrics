package ws.ament.mp.metrics.codahale;

import com.codahale.metrics.Counter;

public class DelegateCounter extends Counter {
    private final org.eclipse.microprofile.metrics.Counter delegate;

    public DelegateCounter(org.eclipse.microprofile.metrics.Counter delegate) {
        this.delegate = delegate;
    }

    @Override
    public void inc() {
        delegate.inc();
    }

    @Override
    public void inc(long l) {
        delegate.inc(l);
    }

    @Override
    public void dec() {
        delegate.dec();
    }

    @Override
    public void dec(long l) {
        delegate.dec(l);
    }

    @Override
    public long getCount() {
        return delegate.getCount();
    }
}
