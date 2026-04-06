import java.util.HashMap;
import java.util.Map;

public class InMemoryDatabase<K, V> implements Database<K, V> {
    private final Map<K, V> storage = new HashMap<>();

    @Override
    public V get(K key) {
        return storage.get(key);
    }

    @Override
    public void put(K key, V value) {
        storage.put(key, value);
    }
}