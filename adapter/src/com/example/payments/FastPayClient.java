package adapter.src.com.example.payments;

import java.util.UUID;

public class FastPayClient {

    public String createCharge(String customer, int amountInCents) {
        System.out.println("[FastPay] Charging " + customer + " for " + amountInCents + " cents");
        return "FAST-" + UUID.randomUUID();
    }
}
