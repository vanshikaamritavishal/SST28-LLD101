package com.example.tickets;

import java.util.Arrays;

public class TicketService {

    public IncidentTicket createNewTicket() {
        return IncidentTicket.builder()
                .id("INC-1001")
                .reporterEmail("user@example.com")
                .title("VPN not working")
                .description("User cannot connect to VPN from home wifi")
                .priority(IncidentTicket.Priority.HIGH)
                .tags(Arrays.asList("network", "vpn"))
                .customerVisible(true)
                .slaMinutes(60)
                .source("CLI")
                .build();
    }

    public IncidentTicket assignTicket(IncidentTicket existing, String assigneeEmail) {
        return existing.toBuilder()
                .assigneeEmail(assigneeEmail)
                .build();
    }

    public IncidentTicket changePriority(IncidentTicket existing,
                                         IncidentTicket.Priority newPriority) {
        return existing.toBuilder()
                .priority(newPriority)
                .build();
    }
}
