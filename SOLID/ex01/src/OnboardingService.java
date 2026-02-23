public class OnboardingService {

    private StudentParser parser = new StudentParser();
    private StudentValidator validator = new StudentValidator();
    private StudentIdGenerator idGen = new StudentIdGenerator();
    private StudentRepository repo = new StudentRepository();
    private StudentPrinter printer = new StudentPrinter();

    public void registerFromRawInput(String rawInput) {
        System.out.println("=== Student Onboarding ===");
        System.out.println("INPUT: " + rawInput);

        StudentRecord student = parser.parse(rawInput);
        String error = validator.validate(student);
        if (error != null) {
            System.out.println("ERROR: " + error);
            return;
        }

        student.setId(idGen.generateId());
        repo.save(student);
        printer.printConfirmation(student, repo.count());
        printer.printDbDump(repo.all());
    }
}