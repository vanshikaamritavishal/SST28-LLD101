package adapter.src.com.example.payments;

import java.util.Objects;

public class FastPayAdapter implements PaymentGateway {

    private final FastPayClient client;

    public FastPayAdapter(FastPayClient client) {
        this.client = Objects.requireNonNull(client, "fastPayClient must not be null");
    }

    @Override
    public String charge(String customerId, int amountCents) {
        Objects.requireNonNull(customerId, "customerId must not be null");
        if (amountCents <= 0) {
            throw new IllegalArgumentException("amountCents must be > 0");
        }
        return client.createCharge(customerId, amountCents);
    }
}
