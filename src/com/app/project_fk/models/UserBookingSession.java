package com.app.project_fk.models;

import java.util.List;

public class UserBookingSession {

    User user;
    Show show;
    List<Seat> bookingSeatList;
    Payment payment;

    public UserBookingSession(User user, Show show, List<Seat> bookingSeatList) {
        this.user = user;
        this.show = show;
        this.bookingSeatList = bookingSeatList;
        payment = new Payment();
    }

    public void successPayment() {
        this.payment.status = PaymentStatus.SUCCESS;
    }

    public void failPayment() {
        this.payment.status = PaymentStatus.FAILURE;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getBookingSeatList() {
        return bookingSeatList;
    }

    public void setBookingSeatList(List<Seat> bookingSeatList) {
        this.bookingSeatList = bookingSeatList;
    }
}
