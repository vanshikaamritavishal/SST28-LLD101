

import java.util.UUID;

public class SafeCashClient {

    public String pay(String userId, double amountInDollars) {
        // imagine this calls another external SDK
        System.out.println("[SafeCash] Charging " + userId + " for $" + amountInDollars);
        return "SAFE-" + UUID.randomUUID();
    }
}
