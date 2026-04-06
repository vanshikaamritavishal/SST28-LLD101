public interface CounterStore {
    Object get(String storeKey);
    void put(String storeKey, Object value);
}