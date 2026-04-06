public class Main {
    public static void main(String[] args) {
        Database<String, String> database = new InMemoryDatabase<>();
        DistributionStrategy<String> distributionStrategy = new ModuloDistributionStrategy<>();
        EvictionPolicyFactory<String> evictionPolicyFactory = new LRUEvictionPolicyFactory<>();

        DistributedCache<String, String> cache =
                new DistributedCache<>(3, 2, distributionStrategy, database, evictionPolicyFactory);

        cache.put("A", "Apple");
        cache.put("B", "Ball");
        cache.put("C", "Cat");
        cache.put("D", "Dog");

        System.out.println("Get A: " + cache.get("A"));
        System.out.println("Get B: " + cache.get("B"));
        System.out.println("Get C: " + cache.get("C"));
        System.out.println("Get D: " + cache.get("D"));

        database.put("X", "Xylophone");
        System.out.println("Get X: " + cache.get("X"));
        System.out.println("Get X again: " + cache.get("X"));
    }
}