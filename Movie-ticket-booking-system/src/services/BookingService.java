package services;

import enums.BookingStatus;
import enums.PaymentMethod;
import enums.PaymentStatus;
import models.*;
import repositories.BookingRepository;
import utils.IdGenerator;

import java.util.List;

public class BookingService {
    private final BookingRepository bookingRepository;
    private final PricingService pricingService;

    public BookingService(BookingRepository bookingRepository, PricingService pricingService) {
        this.bookingRepository = bookingRepository;
        this.pricingService = pricingService;
    }

    public Ticket bookTicket(Customer customer, Show show, List<Seat> seats, PaymentMethod paymentMethod) {
        if (!show.areSeatsAvailable(seats)) {
            throw new RuntimeException("Selected seats are not available.");
        }

        double totalAmount = pricingService.calculatePrice(show, seats);
        Booking booking = new Booking(IdGenerator.generateId(), show, customer, seats);

        Payment payment = new Payment(
                IdGenerator.generateId(),
                totalAmount,
                paymentMethod,
                PaymentStatus.SUCCESS
        );

        show.bookSeats(seats);

        Ticket ticket = new Ticket(
                IdGenerator.generateId(),
                show,
                customer,
                seats,
                totalAmount
        );

        booking.setPayment(payment);
        booking.setTicket(ticket);
        booking.setStatus(BookingStatus.CONFIRMED);
        bookingRepository.save(booking);

        return ticket;
    }

    public void cancelBooking(Booking booking) {
        booking.getShow().releaseSeats(booking.getSeats());
        booking.setStatus(BookingStatus.CANCELLED);
    }
}