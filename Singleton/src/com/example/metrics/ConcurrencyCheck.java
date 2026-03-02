package com.example.metrics;

public class ConcurrencyCheck {

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            MetricsRegistry registry = MetricsRegistry.getInstance();
            registry.increment("CONCURRENT_HITS");
            System.out.println(Thread.currentThread().getName()
                    + " instance hash = " + registry.hashCode());
        };

        Thread t1 = new Thread(task, "T1");
        Thread t2 = new Thread(task, "T2");
        Thread t3 = new Thread(task, "T3");
        Thread t4 = new Thread(task, "T4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        MetricsRegistry registry = MetricsRegistry.getInstance();
        System.out.println("CONCURRENT_HITS = " + registry.getCount("CONCURRENT_HITS"));
    }
}
