public class StudentValidator {

    private static final String[] ALLOWED_PROGRAMS = {"CSE", "ECE", "ME"};

    public String validate(StudentRecord student) {
        if (student.getName() == null || student.getName().isEmpty())
            return "Name is empty";
        if (student.toString().contains("@") == false || !student.toString().contains("email"))
            return "Invalid email"; // simplified for demo
        if (!student.toString().matches(".*\\d{10}.*"))
            return "Phone invalid";
        boolean programValid = false;
        for (String p : ALLOWED_PROGRAMS) if (p.equals(student.getProgram())) programValid = true;
        if (!programValid) return "Program invalid";
        return null; // all good
    }
}