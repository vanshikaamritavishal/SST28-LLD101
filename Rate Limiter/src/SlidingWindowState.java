import java.util.concurrent.atomic.AtomicInteger;

public class SlidingWindowState {
    private volatile long currentWindowStartMillis;
    private final AtomicInteger currentCount;
    private volatile long previousWindowStartMillis;
    private final AtomicInteger previousCount;

    public SlidingWindowState(long currentWindowStartMillis, long previousWindowStartMillis) {
        this.currentWindowStartMillis = currentWindowStartMillis;
        this.previousWindowStartMillis = previousWindowStartMillis;
        this.currentCount = new AtomicInteger(0);
        this.previousCount = new AtomicInteger(0);
    }

    public long getCurrentWindowStartMillis() {
        return currentWindowStartMillis;
    }

    public void setCurrentWindowStartMillis(long currentWindowStartMillis) {
        this.currentWindowStartMillis = currentWindowStartMillis;
    }

    public AtomicInteger getCurrentCount() {
        return currentCount;
    }

    public long getPreviousWindowStartMillis() {
        return previousWindowStartMillis;
    }

    public void setPreviousWindowStartMillis(long previousWindowStartMillis) {
        this.previousWindowStartMillis = previousWindowStartMillis;
    }

    public AtomicInteger getPreviousCount() {
        return previousCount;
    }
}