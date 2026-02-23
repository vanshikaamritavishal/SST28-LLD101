public class StudentRecord {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String program;

    public StudentRecord(String name, String email, String phone, String program) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.program = program;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getProgram() { return program; }

    @Override
    public String toString() {
        return "StudentRecord{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", program='" + program + '\'' +
                '}';
    }
}