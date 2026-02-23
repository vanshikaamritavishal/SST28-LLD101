import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private List<StudentRecord> db = new ArrayList<>();

    public void save(StudentRecord student) {
        db.add(student);
    }

    public int count() { return db.size(); }
    public List<StudentRecord> all() { return db; }
}