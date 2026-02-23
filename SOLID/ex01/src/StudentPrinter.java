import java.util.List;

public class StudentPrinter {

    public void printConfirmation(StudentRecord student, int totalCount) {
        System.out.println("OK: created student " + student.getId());
        System.out.println("Saved. Total students: " + totalCount);
        System.out.println("CONFIRMATION:");
        System.out.println(student);
        System.out.println("\n-- DB DUMP --");
    }

    public void printDbDump(List<StudentRecord> students) {
        System.out.println("| ID             | NAME | PROGRAM |");
        for (StudentRecord s : students) {
            System.out.printf("| %-14s | %-4s | %-7s |\n",
                    s.getId(), s.getName(), s.getProgram());
        }
    }
}