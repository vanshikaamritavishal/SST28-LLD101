package repositories;

import models.Booking;

import java.util.*;

public class BookingRepository {
    private final Map<String, Booking> bookings = new HashMap<>();

    public void save(Booking booking) {
        bookings.put(booking.getId(), booking);
    }

    public Booking findById(String id) {
        return bookings.get(id);
    }

    public List<Booking> findAll() {
        return new ArrayList<>(bookings.values());
    }
}