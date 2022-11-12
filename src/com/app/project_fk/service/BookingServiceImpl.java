package com.app.project_fk.service;

import com.app.Solution;
import com.app.project_fk.InvalidSeatException;
import com.app.project_fk.models.*;

import java.util.ArrayList;
import java.util.List;

public class BookingServiceImpl implements BookingService {

    List<Show> showList;

    public BookingServiceImpl( ) {
        this.showList = new ArrayList<>();
    }

    public List<Show> getShowList() {
        return showList;
    }

    public void setShowList(List<Show> showList) {
        this.showList = showList;
    }

    public void addShow(Show show) {
        this.showList.add(show);
    }

    @Override
    public List<Show> getAllShows() {
        return showList;
    }

    @Override
    public List<Seat> getAvailableSeatsForShow(Show show) {
        return show.getAvailableSeats();
    }

    @Override
    public UserBookingSession reserveSeatsForUser(User user, Show show, List<Integer> seatNums) throws InvalidSeatException {

        List<Seat> aSeats = getAvailableSeatsForShow(show);
        List<Seat> bookedSeats = new ArrayList<>();
        UserBookingSession session;

        synchronized (show) {
            for (Integer n : seatNums) {

                Seat s = null; // want to book seat
                for (Seat a : aSeats) {
                    if (a.getNumber() == n) {
                        s = a;
                        break;
                    }
                }
                if (s == null || s.getStatus() != SeatStatus.AVAILABLE) {
                    throw new InvalidSeatException();
                }
                s.setStatus(SeatStatus.TEMPORARILY_UNAVAILABLE);
                bookedSeats.add(s);
            }
            session = new UserBookingSession(user, show, bookedSeats);
        }
        return session;
    }

    @Override
    public void sucessPayment(UserBookingSession userBookingSession) {
        userBookingSession.successPayment();
        Show show = userBookingSession.getShow();
        synchronized (show) {
            List<Seat> bookedSeats = userBookingSession.getBookingSeatList();
            for (Seat s : bookedSeats) {
                s.setStatus(SeatStatus.PERMANENTLY_UNAVAILABLE);
            }
        }
    }

    @Override
    public void failPayment(UserBookingSession userBookingSession) {

        Show show = userBookingSession.getShow();
        synchronized (show) {
            userBookingSession.failPayment();
            List<Seat> bookedSeats = userBookingSession.getBookingSeatList();
            for (Seat s : bookedSeats) {
                s.setStatus(SeatStatus.AVAILABLE);
            }
        }
    }


}
