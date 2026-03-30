package models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Show {
    private String id;
    private Movie movie;
    private Theatre theatre;
    private Screen screen;
    private LocalDateTime startTime;
    private Set<String> bookedSeatIds;

    public Show(String id, Movie movie, Theatre theatre, Screen screen, LocalDateTime startTime) {
        this.id = id;
        this.movie = movie;
        this.theatre = theatre;
        this.screen = screen;
        this.startTime = startTime;
        this.bookedSeatIds = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public Screen getScreen() {
        return screen;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public boolean areSeatsAvailable(List<Seat> seats) {
        for (Seat seat : seats) {
            if (bookedSeatIds.contains(seat.getId())) {
                return false;
            }
        }
        return true;
    }

    public void bookSeats(List<Seat> seats) {
        for (Seat seat : seats) {
            bookedSeatIds.add(seat.getId());
        }
    }

    public void releaseSeats(List<Seat> seats) {
        for (Seat seat : seats) {
            bookedSeatIds.remove(seat.getId());
        }
    }
}