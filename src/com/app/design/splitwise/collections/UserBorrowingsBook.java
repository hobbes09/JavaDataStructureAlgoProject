package com.app.design.splitwise.collections;

import com.app.design.splitwise.models.Borrow;
import com.app.design.splitwise.models.Transaction;
import com.app.design.splitwise.models.User;

import java.util.ArrayList;

public class UserBorrowingsBook implements UpdateBook{
    User user;

    /*
    Collection of all borrowings of a user, per transaction.
    This is the track the overall a user has made.
     */
    ArrayList<Borrow> borrowings;

    public UserBorrowingsBook(User user) {
        this.user = user;
        this.borrowings = new ArrayList<>();
    }

    public void addBorrow(Borrow borrow) {
        if (this.borrowings == null)
            this.borrowings = new ArrayList<>();

        this.borrowings.add(borrow);
    }

    @Override
    public void updateBookOnTransactionCommit(Transaction transaction) {
        ArrayList<Borrow> borrows = transaction.individualBorrows;
        for(Borrow borrow: borrows) {
            if(borrow.borrower.getId() == this.user.getId()) {
                addBorrow(borrow);
            }
        }
    }
}
