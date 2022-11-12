package com.app.project_fk.service;

import com.app.project_fk.InvalidSeatException;
import com.app.project_fk.models.Seat;
import com.app.project_fk.models.Show;
import com.app.project_fk.models.User;
import com.app.project_fk.models.UserBookingSession;

import java.util.List;

public interface BookingService {

    public void addShow(Show show);

    public List<Show> getAllShows();

    public List<Seat> getAvailableSeatsForShow(Show show);

    public UserBookingSession reserveSeatsForUser(User user, Show show, List<Integer> seatNums) throws InvalidSeatException;

    public void sucessPayment(UserBookingSession userBookingSession);

    public void failPayment(UserBookingSession userBookingSession);

}
