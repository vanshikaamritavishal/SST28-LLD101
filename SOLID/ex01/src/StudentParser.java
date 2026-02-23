public class StudentParser {

    public StudentRecord parse(String rawInput) {
        String[] parts = rawInput.split(";");
        String name="", email="", phone="", program="";
        for (String part : parts) {
            String[] kv = part.split("=");
            switch (kv[0].trim()) {
                case "name": name = kv[1]; break;
                case "email": email = kv[1]; break;
                case "phone": phone = kv[1]; break;
                case "program": program = kv[1]; break;
            }
        }
        return new StudentRecord(name, email, phone, program);
    }
}