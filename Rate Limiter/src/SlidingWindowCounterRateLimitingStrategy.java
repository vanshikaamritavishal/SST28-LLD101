public class SlidingWindowCounterRateLimitingStrategy implements RateLimitingStrategy {

    @Override
    public RateLimitResult allow(RateLimitRequest request, CounterStore store, TimeProvider timeProvider) {
        String storeKey = "SW:" + request.getKey() + ":" + request.getRule().getWindowSizeInMillis();
        long now = timeProvider.currentTimeMillis();
        long windowSize = request.getRule().getWindowSizeInMillis();

        long currentWindowStart = (now / windowSize) * windowSize;
        long previousWindowStart = currentWindowStart - windowSize;

        SlidingWindowState state = (SlidingWindowState) store.get(storeKey);
        if (state == null) {
            state = new SlidingWindowState(currentWindowStart, previousWindowStart);
            store.put(storeKey, state);
        }

        synchronized (state) {
            if (state.getCurrentWindowStartMillis() != currentWindowStart) {
                if (state.getCurrentWindowStartMillis() == previousWindowStart) {
                    state.getPreviousCount().set(state.getCurrentCount().get());
                    state.setPreviousWindowStartMillis(previousWindowStart);
                } else {
                    state.getPreviousCount().set(0);
                    state.setPreviousWindowStartMillis(previousWindowStart);
                }

                state.getCurrentCount().set(0);
                state.setCurrentWindowStartMillis(currentWindowStart);
            }

            long elapsedInCurrentWindow = now - currentWindowStart;
            double weightOfPreviousWindow = (double) (windowSize - elapsedInCurrentWindow) / windowSize;

            double weightedCount = state.getCurrentCount().get() +
                    (state.getPreviousCount().get() * weightOfPreviousWindow);

            if (weightedCount >= request.getRule().getLimit()) {
                long retryAfter = windowSize - elapsedInCurrentWindow;
                return new RateLimitResult(false, 0, retryAfter, "Rate limit exceeded - Sliding Window");
            }

            int used = state.getCurrentCount().incrementAndGet();
            double newWeightedCount = used + (state.getPreviousCount().get() * weightOfPreviousWindow);
            int remaining = Math.max(0, request.getRule().getLimit() - (int) Math.ceil(newWeightedCount));

            return new RateLimitResult(true, remaining, 0, "Allowed - Sliding Window");
        }
    }
}