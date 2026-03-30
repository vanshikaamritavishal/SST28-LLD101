package models;

import java.util.List;

public class Ticket {
    private String id;
    private Show show;
    private Customer customer;
    private List<Seat> seats;
    private double totalAmount;

    public Ticket(String id, Show show, Customer customer, List<Seat> seats, double totalAmount) {
        this.id = id;
        this.show = show;
        this.customer = customer;
        this.seats = seats;
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Ticket{id='" + id + "', movie='" + show.getMovie().getTitle() +
                "', theatre='" + show.getTheatre().getName() + "', seats=" + seats +
                ", totalAmount=" + totalAmount + "}";
    }
}