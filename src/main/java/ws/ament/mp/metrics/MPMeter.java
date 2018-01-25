package ws.ament.mp.metrics;


import com.codahale.metrics.Meter;

public class MPMeter implements org.eclipse.microprofile.metrics.Meter, MPDropwizard<Meter> {
    private final Meter delegate;

    MPMeter(Meter delegate) {
        this.delegate = delegate;
    }
    public void mark() {
        this.delegate.mark();
    }

    public void mark(long l) {
        this.delegate.mark(l);
    }

    public long getCount() {
        return this.delegate.getCount();
    }

    public double getFifteenMinuteRate() {
        return this.delegate.getFifteenMinuteRate();
    }

    public double getFiveMinuteRate() {
        return this.delegate.getFiveMinuteRate();
    }

    public double getMeanRate() {
        return this.delegate.getMeanRate();
    }

    public double getOneMinuteRate() {
        return this.delegate.getOneMinuteRate();
    }

    @Override
    public Meter getDelegate() {
        return delegate;
    }
}
