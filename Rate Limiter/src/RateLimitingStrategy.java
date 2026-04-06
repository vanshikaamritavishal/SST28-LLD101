public interface RateLimitingStrategy {
    RateLimitResult allow(RateLimitRequest request, CounterStore store, TimeProvider timeProvider);
}