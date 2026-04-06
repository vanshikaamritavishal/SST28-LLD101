public class FixedWindowRateLimitingStrategy implements RateLimitingStrategy {

    @Override
    public RateLimitResult allow(RateLimitRequest request, CounterStore store, TimeProvider timeProvider) {
        String storeKey = "FW:" + request.getKey() + ":" + request.getRule().getWindowSizeInMillis();
        long now = timeProvider.currentTimeMillis();
        long windowSize = request.getRule().getWindowSizeInMillis();
        long windowStart = (now / windowSize) * windowSize;

        FixedWindowState state = (FixedWindowState) store.get(storeKey);
        if (state == null) {
            state = new FixedWindowState(windowStart);
            store.put(storeKey, state);
        }

        synchronized (state) {
            if (state.getWindowStartMillis() != windowStart) {
                state.setWindowStartMillis(windowStart);
                state.getCount().set(0);
            }

            if (state.getCount().get() >= request.getRule().getLimit()) {
                long retryAfter = (windowStart + windowSize) - now;
                return new RateLimitResult(false, 0, retryAfter, "Rate limit exceeded - Fixed Window");
            }

            int used = state.getCount().incrementAndGet();
            int remaining = request.getRule().getLimit() - used;
            return new RateLimitResult(true, remaining, 0, "Allowed - Fixed Window");
        }
    }
}