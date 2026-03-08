

import java.util.UUID;

public class FastPayClient {

    public String createCharge(String customer, int amountInCents) {
        // imagine this calls an external SDK
        System.out.println("[FastPay] Charging " + customer + " for " + amountInCents + " cents");
        return "FAST-" + UUID.randomUUID();
    }
}
