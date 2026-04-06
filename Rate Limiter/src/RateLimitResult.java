public class RateLimitResult {
    private final boolean allowed;
    private final int remaining;
    private final long retryAfterMillis;
    private final String message;

    public RateLimitResult(boolean allowed, int remaining, long retryAfterMillis, String message) {
        this.allowed = allowed;
        this.remaining = remaining;
        this.retryAfterMillis = retryAfterMillis;
        this.message = message;
    }

    public boolean isAllowed() {
        return allowed;
    }

    public int getRemaining() {
        return remaining;
    }

    public long getRetryAfterMillis() {
        return retryAfterMillis;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "RateLimitResult{" +
                "allowed=" + allowed +
                ", remaining=" + remaining +
                ", retryAfterMillis=" + retryAfterMillis +
                ", message='" + message + '\'' +
                '}';
    }
}