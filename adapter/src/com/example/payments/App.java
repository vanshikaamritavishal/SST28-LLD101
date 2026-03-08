package adapter.src.com.example.payments;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        Map<String, PaymentGateway> gateways = new HashMap<>();
        gateways.put("FASTPAY", new FastPayAdapter(new FastPayClient()));
        gateways.put("SAFECASH", new SafeCashAdapter(new SafeCashClient()));

        runOrderWithProvider("FASTPAY", gateways);
        System.out.println("------------------------------");
        runOrderWithProvider("SAFECASH", gateways);
    }

    private static void runOrderWithProvider(String providerKey,
                                             Map<String, PaymentGateway> registry) {
        PaymentGateway gateway = registry.get(providerKey);
        if (gateway == null) {
            System.out.println("No gateway registered for provider " + providerKey);
            return;
        }

        System.out.println("=== Using provider: " + providerKey + " ===");
        OrderService orderService = new OrderService(gateway);

        String customerId = "cust-123";
        int amountCents = 4999;

        String txnId = orderService.placeOrder(customerId, amountCents);
        System.out.println("Transaction ID from " + providerKey + ": " + txnId);
    }
}
