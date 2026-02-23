public class StudentIdGenerator {
    private int counter = 0;

    public String generateId() {
        counter++;
        return String.format("SST-2026-%04d", counter);
    }
}