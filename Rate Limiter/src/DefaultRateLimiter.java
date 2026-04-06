public class DefaultRateLimiter implements RateLimiter {
    private final RateLimitingStrategy strategy;
    private final CounterStore store;
    private final TimeProvider timeProvider;

    public DefaultRateLimiter(RateLimitingStrategy strategy, CounterStore store, TimeProvider timeProvider) {
        this.strategy = strategy;
        this.store = store;
        this.timeProvider = timeProvider;
    }

    @Override
    public RateLimitResult allow(RateLimitRequest request) {
        return strategy.allow(request, store, timeProvider);
    }
}