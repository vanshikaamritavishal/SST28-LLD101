package adapter.src.com.example.payments;

public interface PaymentGateway {
    String charge(String customerId, int amountCents);
}
