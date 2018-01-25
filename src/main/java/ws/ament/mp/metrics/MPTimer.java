package ws.ament.mp.metrics;

import com.codahale.metrics.Timer;
import org.eclipse.microprofile.metrics.Snapshot;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class MPTimer implements org.eclipse.microprofile.metrics.Timer, MPDropwizard<Timer> {
    private final Timer delegate;

    MPTimer(Timer delegate) {
        this.delegate = delegate;
    }

    public void update(long l, TimeUnit timeUnit) {
        this.delegate.update(l, timeUnit);
    }

    public <T> T time(Callable<T> callable) throws Exception {
        return this.delegate.time(callable);
    }

    public void time(Runnable runnable) {
        this.delegate.time(runnable);
    }

    public Context time() {
        return new MPContext(delegate.time());
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

    public Snapshot getSnapshot() {
        return new MPSnapshot(delegate.getSnapshot());
    }

    @Override
    public Timer getDelegate() {
        return delegate;
    }

    private final class MPContext implements org.eclipse.microprofile.metrics.Timer.Context {
        private final Timer.Context delegate;

        MPContext(Timer.Context delegate) {
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
