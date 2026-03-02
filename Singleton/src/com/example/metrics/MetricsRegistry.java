package com.example.metrics;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class MetricsRegistry implements Serializable {

    private static final long serialVersionUID = 1L;

    private static volatile MetricsRegistry instance;
    private static boolean instanceCreated = false;

    private final Map<String, Long> counters = new HashMap<>();

    private MetricsRegistry() {
        synchronized (MetricsRegistry.class) {
            if (instanceCreated) {
                throw new IllegalStateException("MetricsRegistry instance already created");
            }
            instanceCreated = true;
        }
    }

    public static MetricsRegistry getInstance() {
        MetricsRegistry result = instance;
        if (result == null) {
            synchronized (MetricsRegistry.class) {
                result = instance;
                if (result == null) {
                    result = new MetricsRegistry();
                    instance = result;
                }
            }
        }
        return result;
    }

    public synchronized void increment(String key) {
        long current = counters.getOrDefault(key, 0L);
        counters.put(key, current + 1);
    }

    public synchronized long getCount(String key) {
        return counters.getOrDefault(key, 0L);
    }

    public synchronized Map<String, Long> getAll() {
        return Collections.unmodifiableMap(new HashMap<>(counters));
    }

    private Object readResolve() throws ObjectStreamException {
        return getInstance();
    }
}
