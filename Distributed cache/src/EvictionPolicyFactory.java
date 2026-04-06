public interface EvictionPolicyFactory<K> {
    EvictionPolicy<K> createEvictionPolicy();
}