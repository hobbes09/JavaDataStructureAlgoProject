package com.app.design.booking.models;

public class Seat {
    int number;
    SeatStatus status;

    public Seat(int number, SeatStatus status) {
        this.number = number;
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }
}
