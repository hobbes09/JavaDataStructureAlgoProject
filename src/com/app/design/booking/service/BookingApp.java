package com.app.design.booking.service;

import com.app.Solution;
import com.app.design.booking.InvalidSeatException;
import com.app.design.booking.models.*;

import java.util.ArrayList;
import java.util.List;

public class BookingApp implements Solution {

    List<UserBookingSession> userBookingSessionList;
    List<Show> showList;

    @Override
    public void execute() {

            Screen screen = new Screen("screen1", 10);
            ArrayList<Screen> screens = new ArrayList<>();
            screens.add(screen);
            Theater thater = new Theater("thater1", screens);
            BookingService bookingService = new BookingServiceImpl();
            Show show = new Show(thater, new Movie("movie1", 90), screen, 123465);
            bookingService.addShow(show);

            User u1 = new User("e1");
            List<Seat> availableSeats = bookingService.getAvailableSeatsForShow(show);
            System.out.println(availableSeats.size());

            List<Integer> u1SeatNums = new ArrayList<>();
            u1SeatNums.add(0);
            u1SeatNums.add(1);
            u1SeatNums.add(2);

        try {
            UserBookingSession s1 = bookingService.reserveSeatsForUser(u1, show, u1SeatNums);
            System.out.println(bookingService.getAvailableSeatsForShow(show).size());
        } catch (InvalidSeatException e) {
            System.out.println("Seats Unavailabnle : " + u1SeatNums.toString());
            e.printStackTrace();
        }

            User u2 = new User("e2");
            List<Integer> u2SeatNums = new ArrayList<>();
            u2SeatNums.add(3);
            u2SeatNums.add(4);

        try {
            UserBookingSession s2 = bookingService.reserveSeatsForUser(u2, show, u2SeatNums);
            System.out.println(bookingService.getAvailableSeatsForShow(show).size());
        } catch (InvalidSeatException e) {
            System.out.println("Seats Unavailabnle : " + u2SeatNums.toString());
            e.printStackTrace();
        }

        User u3 = new User("e3");
        List<Integer> u3SeatNums = new ArrayList<>();
        u3SeatNums.add(3);
        u3SeatNums.add(5);

        try {
            UserBookingSession s3 = bookingService.reserveSeatsForUser(u3, show, u3SeatNums);
            System.out.println(bookingService.getAvailableSeatsForShow(show).size());
        } catch (InvalidSeatException e) {
            System.out.println("Seats Unavailabnle : " + u3SeatNums.toString());
            e.printStackTrace();
        }



    }
}
