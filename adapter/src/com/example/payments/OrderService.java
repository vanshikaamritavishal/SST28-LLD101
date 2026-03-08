package adapter.src.com.example.payments;

import java.util.Objects;

public class OrderService {

    private final PaymentGateway paymentGateway;

    public OrderService(PaymentGateway paymentGateway) {
        this.paymentGateway = Objects.requireNonNull(paymentGateway, "paymentGateway must not be null");
    }

    public String placeOrder(String customerId, int amountCents) {
        System.out.println("[OrderService] Placing order for " + customerId
                + " amount: " + amountCents + " cents");
        String txnId = paymentGateway.charge(customerId, amountCents);
        System.out.println("[OrderService] Payment successful, txnId=" + txnId);
        return txnId;
    }
}
