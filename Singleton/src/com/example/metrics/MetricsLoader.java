package com.example.metrics;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MetricsLoader {

    public void loadInitialMetrics() {
        MetricsRegistry registry = MetricsRegistry.getInstance();

        Properties props = new Properties();
        try (InputStream in = getClass().getClassLoader()
                .getResourceAsStream("metrics.properties")) {

            if (in == null) {
                System.out.println("metrics.properties not found, skipping initial metrics load");
                return;
            }

            props.load(in);

            for (String key : props.stringPropertyNames()) {
                String value = props.getProperty(key);
                try {
                    long count = Long.parseLong(value);
                    for (int i = 0; i < count; i++) {
                        registry.increment(key);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid metric value for key " + key + ": " + value);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading metrics.properties: " + e.getMessage());
        }
    }
}
