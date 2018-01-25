package ws.ament.mp.metrics.codahale;

import com.codahale.metrics.Clock;
import com.codahale.metrics.Snapshot;
import com.codahale.metrics.Timer;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class DelegateTimer extends Timer {
    private final org.eclipse.microprofile.metrics.Timer delegate;

    public DelegateTimer(org.eclipse.microprofile.metrics.Timer delegate) {
        this.delegate = delegate;
    }

    @Override
    public void update(long l, TimeUnit timeUnit) {
        delegate.update(l, timeUnit);
    }

    @Override
    public <T> T time(Callable<T> callable) throws Exception {
        return delegate.time(callable);
    }

    @Override
    public void time(Runnable runnable) {
        delegate.time(runnable);
    }

    @Override
    public Timer.Context time() {
        return new DelegateContext(delegate.time());
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

    @Override
    public Snapshot getSnapshot() {
        return new DelegateSnapshot(delegate.getSnapshot());
    }

    private final class DelegateContext extends com.codahale.metrics.Timer.Context {
        private final org.eclipse.microprofile.metrics.Timer.Context delegate;

        DelegateContext(org.eclipse.microprofile.metrics.Timer.Context delegate) {
            super(DelegateTimer.this, Clock.defaultClock());
            this.delegate = delegate;
        }

        public long stop() {
            return delegate.stop();
        }

        public void close() {
            delegate.close();
        }
    }
}
