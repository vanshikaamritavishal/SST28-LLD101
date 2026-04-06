public class ExternalServiceCaller {
    private final RateLimiter rateLimiter;

    public ExternalServiceCaller(RateLimiter rateLimiter) {
        this.rateLimiter = rateLimiter;
    }

    public void processRequest(String tenantId, boolean shouldCallExternalResource, RateLimitRule rule) {
        System.out.println("Business logic executed for tenant: " + tenantId);

        if (!shouldCallExternalResource) {
            System.out.println("No external call needed, so no rate limiting check performed.");
            return;
        }

        RateLimitRequest request = new RateLimitRequest(tenantId, rule);
        RateLimitResult result = rateLimiter.allow(request);

        if (result.isAllowed()) {
            System.out.println("External resource called successfully for tenant: " + tenantId);
        } else {
            System.out.println("External call denied for tenant: " + tenantId +
                    ", retryAfterMillis=" + result.getRetryAfterMillis());
        }
    }
}