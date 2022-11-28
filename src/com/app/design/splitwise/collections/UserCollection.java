package com.app.design.splitwise.collections;

import com.app.design.splitwise.models.Borrow;
import com.app.design.splitwise.models.Transaction;
import com.app.design.splitwise.models.User;

import java.util.HashMap;

public class UserCollection implements UpdateCollection {
    HashMap<String, User> userCollection;

    @Override
    public void updateCollectionOnTransactionCommit(Transaction transaction) {
        User payer = transaction.expense.payer;
        if (!userCollection.containsKey(payer.getId())) {
            userCollection.put(payer.getId(), payer);
        }
        for (Borrow borrow : transaction.individualBorrows) {
            if (!userCollection.containsKey(borrow.borrower.getId())) {
                userCollection.put(borrow.borrower.getId(), borrow.borrower);
            }
        }
    }


}
