/*******************************************************************************
 * Copyright 2017 Hammock and its contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package ws.ament.mp.metrics;

import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.Gauge;
import org.eclipse.microprofile.metrics.Histogram;
import org.eclipse.microprofile.metrics.Metadata;
import org.eclipse.microprofile.metrics.Meter;
import org.eclipse.microprofile.metrics.Metric;
import org.eclipse.microprofile.metrics.MetricFilter;
import org.eclipse.microprofile.metrics.MetricRegistry;
import org.eclipse.microprofile.metrics.MetricType;
import org.eclipse.microprofile.metrics.Timer;

import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

public class MPMetricsRegistry extends MetricRegistry {

    private com.codahale.metrics.MetricRegistry metricRegistry;

    public MPMetricsRegistry() {
        this(new com.codahale.metrics.MetricRegistry());
    }

    public MPMetricsRegistry(com.codahale.metrics.MetricRegistry metricRegistry) {
        this.metricRegistry = metricRegistry;
    }

    @Override
    public <T extends Metric> T register(String name, T t) throws IllegalArgumentException {
        return register(name, t, new Metadata(name, MetricType.from(t.getClass())));
    }

    @Override
    public <T extends Metric> T register(String name, T t, Metadata metadata) throws IllegalArgumentException {
//        metricRegistry.register(name, new com.codahale.metrics.Metric(t, metadata) {
//        });
        return t;
    }

    public <T extends Metric> T register(Metadata metadata, T t) throws IllegalArgumentException {
        return t;
    }

    @Override
    public Counter counter(String name) {
        return counter(new Metadata(name, MetricType.COUNTER));
    }

    @Override
    public Counter counter(Metadata metadata) {
        com.codahale.metrics.Counter dwDelegate = metricRegistry.counter(metadata.getName());
        return register(metadata.getName(), new MPCounter(dwDelegate), metadata);
    }

    @Override
    public Histogram histogram(String name) {
        return histogram(new Metadata(name, MetricType.HISTOGRAM));
    }

    @Override
    public Histogram histogram(Metadata metadata) {
        com.codahale.metrics.Histogram dwDelegate = metricRegistry.histogram(metadata.getName());
        return register(metadata.getName(), new MPHistogram(dwDelegate), metadata);
    }

    @Override
    public Meter meter(String name) {
        return meter(new Metadata(name, MetricType.METERED));
    }

    @Override
    public Meter meter(Metadata metadata) {
        com.codahale.metrics.Meter dwDelegate = metricRegistry.meter(metadata.getName());
        return register(metadata.getName(), new MPMeter(dwDelegate), metadata);
    }

    @Override
    public Timer timer(String name) {
        return timer(new Metadata(name, MetricType.TIMER));
    }

    @Override
    public Timer timer(Metadata metadata) {
        com.codahale.metrics.Timer dwDelegate = metricRegistry.timer(metadata.getName());
        return register(metadata.getName(), new MPTimer(dwDelegate), metadata);
    }

    @Override
    public boolean remove(String name) {
        return this.metricRegistry.remove(name);
    }

    @Override
    public void removeMatching(MetricFilter metricFilter) {
        this.metricRegistry.removeMatching(new MetricFilterWrapper(metricFilter));
    }

    @Override
    public SortedSet<String> getNames() {
        return this.metricRegistry.getNames();
    }

    @Override
    public SortedMap<String, Gauge> getGauges() {
        return getGauges(MetricFilter.ALL);
    }

    @Override
    public SortedMap<String, Gauge> getGauges(MetricFilter metricFilter) {
        SortedMap<String, com.codahale.metrics.Gauge> gauges = this.metricRegistry.getGauges(new MetricFilterWrapper(metricFilter));
        //TODO gauges
        return null;
    }

    @Override
    public SortedMap<String, Counter> getCounters() {
        return getCounters(MetricFilter.ALL);
    }

    @Override
    public SortedMap<String, Counter> getCounters(MetricFilter metricFilter) {
        Map<String, com.codahale.metrics.Counter> metrics = this.metricRegistry.getCounters(new MetricFilterWrapper(metricFilter));
        //TODO map
        return null;
    }

    @Override
    public SortedMap<String, Histogram> getHistograms() {
        return getHistograms(MetricFilter.ALL);
    }

    @Override
    public SortedMap<String, Histogram> getHistograms(MetricFilter metricFilter) {
        Map<String, com.codahale.metrics.Histogram> histogramMap = this.metricRegistry.getHistograms(new MetricFilterWrapper(metricFilter));
        return null;
    }

    @Override
    public SortedMap<String, Meter> getMeters() {
        return getMeters(MetricFilter.ALL);
    }

    @Override
    public SortedMap<String, Meter> getMeters(MetricFilter metricFilter) {
        Map<String, com.codahale.metrics.Meter> meters = this.metricRegistry.getMeters(new MetricFilterWrapper(metricFilter));
        return null;
    }

    @Override
    public SortedMap<String, Timer> getTimers() {
        return getTimers(MetricFilter.ALL);
    }

    @Override
    public SortedMap<String, Timer> getTimers(MetricFilter metricFilter) {
        Map<String, com.codahale.metrics.Timer> timers = this.metricRegistry.getTimers(new MetricFilterWrapper(metricFilter));
        return null;
    }

    @Override
    public Map<String, Metric> getMetrics() {
        return null;
    }

    @Override
    public Map<String, Metadata> getMetadata() {
        return null;
    }

    private class MetricFilterWrapper implements com.codahale.metrics.MetricFilter {
        private MetricFilter mpFilter;

        public MetricFilterWrapper(MetricFilter mpFilter) {
            this.mpFilter = mpFilter;
        }

        @Override
        public boolean matches(String s, com.codahale.metrics.Metric metric) {
//            return this.mpFilter.matches(s, new Me)
            return false;
        }
    }
}