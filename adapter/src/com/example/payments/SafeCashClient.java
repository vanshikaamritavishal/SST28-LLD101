package adapter.src.com.example.payments;

import java.util.UUID;

public class SafeCashClient {

    public String pay(String userId, double amountInDollars) {
        System.out.println("[SafeCash] Charging " + userId + " for $" + amountInDollars);
        return "SAFE-" + UUID.randomUUID();
    }
}
