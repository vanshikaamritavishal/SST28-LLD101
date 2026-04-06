public class RateLimitRequest {
    private final String key;
    private final RateLimitRule rule;

    public RateLimitRequest(String key, RateLimitRule rule) {
        this.key = key;
        this.rule = rule;
    }

    public String getKey() {
        return key;
    }

    public RateLimitRule getRule() {
        return rule;
    }
}