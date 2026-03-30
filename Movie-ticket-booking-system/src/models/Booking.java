package models;

import enums.BookingStatus;

import java.util.List;

public class Booking {
    private String id;
    private Show show;
    private Customer customer;
    private List<Seat> seats;
    private BookingStatus status;
    private Payment payment;
    private Ticket ticket;

    public Booking(String id, Show show, Customer customer, List<Seat> seats) {
        this.id = id;
        this.show = show;
        this.customer = customer;
        this.seats = seats;
        this.status = BookingStatus.CREATED;
    }

    public String getId() {
        return id;
    }

    public Show getShow() {
        return show;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}