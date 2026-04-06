import java.util.concurrent.atomic.AtomicInteger;

public class FixedWindowState {
    private volatile long windowStartMillis;
    private final AtomicInteger count;

    public FixedWindowState(long windowStartMillis) {
        this.windowStartMillis = windowStartMillis;
        this.count = new AtomicInteger(0);
    }

    public long getWindowStartMillis() {
        return windowStartMillis;
    }

    public void setWindowStartMillis(long windowStartMillis) {
        this.windowStartMillis = windowStartMillis;
    }

    public AtomicInteger getCount() {
        return count;
    }
}