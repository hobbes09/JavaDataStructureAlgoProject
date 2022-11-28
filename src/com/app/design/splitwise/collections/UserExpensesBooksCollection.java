package com.app.design.splitwise.collections;

import com.app.design.splitwise.models.Transaction;
import com.app.design.splitwise.models.User;

import java.util.HashMap;

public class UserExpensesBooksCollection implements UpdateCollection{
    /*
    Map Key = UserId
     */
    HashMap<String, UserExpensesBook> userExpensesCollection;

    public UserExpensesBooksCollection() {
        this.userExpensesCollection = new HashMap<>();
    }

    @Override
    public void updateCollectionOnTransactionCommit(Transaction transaction) {
        User payer = transaction.expense.payer;
        UserExpensesBook payerExpenseBook = userExpensesCollection.getOrDefault(payer.getId(), new UserExpensesBook(payer));
        payerExpenseBook.addExpense(transaction.expense);
        userExpensesCollection.put(payer.getId(), payerExpenseBook);
    }
}
