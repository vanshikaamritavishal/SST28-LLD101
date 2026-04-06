import java.util.ArrayList;
import java.util.List;

public class DistributedCache<K, V> {
    private final List<CacheNode<K, V>> nodes;
    private final DistributionStrategy<K> distributionStrategy;
    private final Database<K, V> database;

    public DistributedCache(
            int numberOfNodes,
            int capacityPerNode,
            DistributionStrategy<K> distributionStrategy,
            Database<K, V> database,
            EvictionPolicyFactory<K> evictionPolicyFactory
    ) {
        this.nodes = new ArrayList<>();
        this.distributionStrategy = distributionStrategy;
        this.database = database;

        for (int i = 0; i < numberOfNodes; i++) {
            nodes.add(new CacheNode<>(
                    "Node-" + i,
                    capacityPerNode,
                    evictionPolicyFactory.createEvictionPolicy()
            ));
        }
    }

    public V get(K key) {
        CacheNode<K, V> node = getNodeForKey(key);
        V value = node.get(key);

        if (value != null) {
            System.out.println("Cache HIT on " + node.getNodeId() + " for key: " + key);
            return value;
        }

        System.out.println("Cache MISS on " + node.getNodeId() + " for key: " + key);

        value = database.get(key);
        if (value != null) {
            System.out.println("Loaded from DB and cached key: " + key);
            node.put(key, value);
        } else {
            System.out.println("Key not found in DB: " + key);
        }

        return value;
    }

    public void put(K key, V value) {
        CacheNode<K, V> node = getNodeForKey(key);
        node.put(key, value);

        database.put(key, value);

        System.out.println("Stored key: " + key + " in " + node.getNodeId());
    }

    private CacheNode<K, V> getNodeForKey(K key) {
        int index = distributionStrategy.getNodeIndex(key, nodes.size());
        return nodes.get(index);
    }
}