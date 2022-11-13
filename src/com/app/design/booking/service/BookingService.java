package com.app.design.booking.service;

import com.app.design.booking.InvalidSeatException;
import com.app.design.booking.models.Seat;
import com.app.design.booking.models.Show;
import com.app.design.booking.models.User;
import com.app.design.booking.models.UserBookingSession;

import java.util.List;

public interface BookingService {

    public void addShow(Show show);

    public List<Show> getAllShows();

    public List<Seat> getAvailableSeatsForShow(Show show);

    public UserBookingSession reserveSeatsForUser(User user, Show show, List<Integer> seatNums) throws InvalidSeatException;

    public void sucessPayment(UserBookingSession userBookingSession);

    public void failPayment(UserBookingSession userBookingSession);

}
