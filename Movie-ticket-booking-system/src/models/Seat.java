package models;

import enums.SeatType;

public class Seat {
    private String id;
    private String seatNumber;
    private SeatType seatType;

    public Seat(String id, String seatNumber, SeatType seatType) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
    }

    public String getId() {
        return id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    @Override
    public String toString() {
        return seatNumber + " (" + seatType + ")";
    }
}