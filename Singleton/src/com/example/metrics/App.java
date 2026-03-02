package com.example.metrics;

public class App {
    public static void main(String[] args) {

        // load initial metrics from metrics.properties (if present)
        MetricsLoader loader = new MetricsLoader();
        loader.loadInitialMetrics();

        MetricsRegistry registry = MetricsRegistry.getInstance();

        // some demo increments
        registry.increment("REQUESTS_TOTAL");
        registry.increment("REQUESTS_TOTAL");
        registry.increment("DB_ERRORS");

        System.out.println("REQUESTS_TOTAL = " + registry.getCount("REQUESTS_TOTAL"));
        System.out.println("DB_ERRORS = " + registry.getCount("DB_ERRORS"));
        System.out.println("All metrics = " + registry.getAll());
    }
}
