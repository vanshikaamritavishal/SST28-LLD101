public class RateLimitRule {
    private final int limit;
    private final long windowSizeInMillis;

    public RateLimitRule(int limit, long windowSizeInMillis) {
        this.limit = limit;
        this.windowSizeInMillis = windowSizeInMillis;
    }

    public int getLimit() {
        return limit;
    }

    public long getWindowSizeInMillis() {
        return windowSizeInMillis;
    }
}