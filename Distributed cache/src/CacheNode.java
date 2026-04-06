import java.util.HashMap;
import java.util.Map;

public class CacheNode<K, V> {
    private final String nodeId;
    private final int capacity;
    private final Map<K, V> storage;
    private final EvictionPolicy<K> evictionPolicy;

    public CacheNode(String nodeId, int capacity, EvictionPolicy<K> evictionPolicy) {
        this.nodeId = nodeId;
        this.capacity = capacity;
        this.evictionPolicy = evictionPolicy;
        this.storage = new HashMap<>();
    }

    public String getNodeId() {
        return nodeId;
    }

    public V get(K key) {
        if (!storage.containsKey(key)) {
            return null;
        }
        evictionPolicy.keyAccessed(key);
        return storage.get(key);
    }

    public void put(K key, V value) {
        if (storage.containsKey(key)) {
            storage.put(key, value);
            evictionPolicy.keyAccessed(key);
            return;
        }

        if (storage.size() >= capacity) {
            K evictKey = evictionPolicy.evictKey();
            if (evictKey != null) {
                storage.remove(evictKey);
                System.out.println("Evicted key: " + evictKey + " from " + nodeId);
            }
        }

        storage.put(key, value);
        evictionPolicy.keyInserted(key);
    }

    public boolean containsKey(K key) {
        return storage.containsKey(key);
    }

    public void remove(K key) {
        if (storage.containsKey(key)) {
            storage.remove(key);
            evictionPolicy.keyRemoved(key);
        }
    }

    public int size() {
        return storage.size();
    }
}