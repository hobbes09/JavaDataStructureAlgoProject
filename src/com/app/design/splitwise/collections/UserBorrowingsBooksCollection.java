package com.app.design.splitwise.collections;

import com.app.design.splitwise.models.Borrow;
import com.app.design.splitwise.models.Transaction;
import com.app.design.splitwise.models.User;

import java.util.HashMap;

public class UserBorrowingsBooksCollection implements UpdateCollection {
    /*
    Map Key = UserId
     */
    HashMap<String, UserBorrowingsBook> userBorrowingsCollection;

    public UserBorrowingsBooksCollection() {
        this.userBorrowingsCollection = new HashMap<>();
    }

    @Override
    public void updateCollectionOnTransactionCommit(Transaction transaction) {
        for (Borrow borrow: transaction.individualBorrows) {
            User borrower = borrow.borrower;
            UserBorrowingsBook borrowingsBook = userBorrowingsCollection.getOrDefault(borrower.getId(), new UserBorrowingsBook(borrower));
            borrowingsBook.addBorrow(borrow);
            userBorrowingsCollection.put(borrower.getId(), borrowingsBook);
        }
    }
}
