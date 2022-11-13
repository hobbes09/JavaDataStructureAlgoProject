package com.app.design.booking.models;

import java.util.ArrayList;
import java.util.List;

public class Show {

    Theater theater;
    Movie movie;
    Screen screen;
    int startTime;
    List<Seat> seatList;

    public Show(Theater theater, Movie movie, Screen screen, int startTime) {
        this.theater = theater;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;

        this.seatList = new ArrayList<>();
        for (int i=0;i<this.screen.seatCount;i++) {
            seatList.add(new Seat(i, SeatStatus.AVAILABLE));
        }
    }

    public List<Seat> getAvailableSeats() {
        List<Seat> seats = new ArrayList<>();
        for (Seat s : this.seatList) {
            if (s.status == SeatStatus.AVAILABLE) {
                seats.add(s);
            }
        }
        return seats;
    }
}
