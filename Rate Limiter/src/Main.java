public class Main {
    public static void main(String[] args) throws InterruptedException {
        RateLimitRule rule = new RateLimitRule(5, 60_000);

        CounterStore fixedWindowStore = new InMemoryCounterStore();
        CounterStore slidingWindowStore = new InMemoryCounterStore();
        TimeProvider timeProvider = new SystemTimeProvider();

        RateLimiter fixedWindowLimiter = new DefaultRateLimiter(
                new FixedWindowRateLimitingStrategy(),
                fixedWindowStore,
                timeProvider
        );

        RateLimiter slidingWindowLimiter = new DefaultRateLimiter(
                new SlidingWindowCounterRateLimitingStrategy(),
                slidingWindowStore,
                timeProvider
        );

        System.out.println("=== Fixed Window Demo ===");
        ExternalServiceCaller fixedWindowCaller = new ExternalServiceCaller(fixedWindowLimiter);
        for (int i = 1; i <= 6; i++) {
            System.out.println("Request " + i);
            fixedWindowCaller.processRequest("T1", true, rule);
        }

        System.out.println("\n=== Sliding Window Demo ===");
        ExternalServiceCaller slidingWindowCaller = new ExternalServiceCaller(slidingWindowLimiter);
        for (int i = 1; i <= 6; i++) {
            System.out.println("Request " + i);
            slidingWindowCaller.processRequest("T1", true, rule);
        }

        System.out.println("\n=== No external call example ===");
        slidingWindowCaller.processRequest("T1", false, rule);
    }
}