import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class InMemoryCounterStore implements CounterStore {
    private final ConcurrentMap<String, Object> store = new ConcurrentHashMap<>();

    @Override
    public Object get(String storeKey) {
        return store.get(storeKey);
    }

    @Override
    public void put(String storeKey, Object value) {
        store.put(storeKey, value);
    }
}