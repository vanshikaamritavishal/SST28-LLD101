public class Main {
    public static void main(String[] args) {
        OnboardingService service = new OnboardingService();
        service.registerFromRawInput("name=Riya;email=riya@sst.edu;phone=9876543210;program=CSE");
    }
}