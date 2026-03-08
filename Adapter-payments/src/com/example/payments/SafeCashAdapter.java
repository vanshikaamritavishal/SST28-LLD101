

import java.util.Objects;

public class SafeCashAdapter implements PaymentGateway {

    private final SafeCashClient client;

    public SafeCashAdapter(SafeCashClient client) {
        this.client = Objects.requireNonNull(client, "safeCashClient must not be null");
    }

    @Override
    public String charge(String customerId, int amountCents) {
        Objects.requireNonNull(customerId, "customerId must not be null");
        if (amountCents <= 0) {
            throw new IllegalArgumentException("amountCents must be > 0");
        }

        double amountDollars = amountCents / 100.0;
        return client.pay(customerId, amountDollars);
    }
}
