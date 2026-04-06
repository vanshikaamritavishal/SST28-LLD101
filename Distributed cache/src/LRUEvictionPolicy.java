import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class LRUEvictionPolicy<K> implements EvictionPolicy<K> {
    private final Set<K> order = new LinkedHashSet<>();

    @Override
    public void keyAccessed(K key) {
        order.remove(key);
        order.add(key);
    }

    @Override
    public void keyInserted(K key) {
        order.remove(key);
        order.add(key);
    }

    @Override
    public void keyRemoved(K key) {
        order.remove(key);
    }

    @Override
    public K evictKey() {
        Iterator<K> iterator = order.iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        K lruKey = iterator.next();
        iterator.remove();
        return lruKey;
    }
}