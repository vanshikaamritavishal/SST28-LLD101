public interface RateLimiter {
    RateLimitResult allow(RateLimitRequest request);
}