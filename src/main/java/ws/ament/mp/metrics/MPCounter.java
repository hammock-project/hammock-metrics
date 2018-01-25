package ws.ament.mp.metrics;

import com.codahale.metrics.Counter;

public class MPCounter implements org.eclipse.microprofile.metrics.Counter, MPDropwizard<Counter> {
    private final Counter delegate;

    MPCounter(Counter delegate) {
        this.delegate = delegate;
    }

    public void inc() {
        this.delegate.inc();
    }

    public void inc(long l) {
        this.delegate.inc(l);
    }

    public void dec() {
        this.delegate.dec();
    }

    public void dec(long l) {
        this.delegate.dec(l);
    }

    public long getCount() {
        return this.delegate.getCount();
    }

    @Override
    public Counter getDelegate() {
        return delegate;
    }
}
