import com.example.tickets.IncidentTicket;
import com.example.tickets.TicketService;

public class TryIt {
    public static void main(String[] args) {
        TicketService service = new TicketService();

        IncidentTicket created = service.createNewTicket();
        System.out.println("Original assignee: " + created.getAssigneeEmail());
        System.out.println("Tags: " + created.getTags());

        IncidentTicket assigned = service.assignTicket(created, "agent@example.com");
        System.out.println("After assignment (new object) assignee: " + assigned.getAssigneeEmail());
        System.out.println("Original still unchanged: " + created.getAssigneeEmail());

        try {
            created.getTags().add("hack");
        } catch (UnsupportedOperationException ex) {
            System.out.println("Cannot modify tags list from outside");
        }
    }
}
