package com.app.design.splitwise.collections;

import com.app.design.splitwise.models.Borrow;
import com.app.design.splitwise.models.Transaction;
import com.app.design.splitwise.models.User;

import java.util.HashMap;

public class UserBalanceBooksCollection implements UpdateCollection{
    /*
    Map Key = UserId
     */
    HashMap<String, UserBalanceBook> userBalanceBookCollection;

    public UserBalanceBooksCollection() {
        this.userBalanceBookCollection = new HashMap<>();
    }

    @Override
    public void updateCollectionOnTransactionCommit(Transaction transaction) {
        updateUserCollectionOnTransactionCommit(transaction.expense.payer, transaction);
        for (Borrow borrow: transaction.individualBorrows) {
            User borrower = borrow.borrower;
            updateUserCollectionOnTransactionCommit(borrower, transaction);
        }
    }

    public void updateUserCollectionOnTransactionCommit(User user, Transaction transaction) {
        UserBalanceBook userBalanceBook = userBalanceBookCollection.getOrDefault(user.getId(), new UserBalanceBook(user));
        userBalanceBook.updateBookOnTransactionCommit(transaction);
        userBalanceBookCollection.put(user.getId(), userBalanceBook);
    }
}
