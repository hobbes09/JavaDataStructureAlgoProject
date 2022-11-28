package com.app.design.splitwise.collections;

import com.app.design.splitwise.models.Expense;
import com.app.design.splitwise.models.Transaction;
import com.app.design.splitwise.models.User;

import java.util.ArrayList;

public class UserExpensesBook implements UpdateBook {
    User user;

    /*
    Collection of all expenditures made by a user, per transaction.
    This is the track the overall expenses a user has made.
     */
    ArrayList<Expense> expenses;

    public UserExpensesBook(User user) {
        this.user = user;
        this.expenses = new ArrayList<>();
    }

    public void addExpense(Expense expense) {
        if (this.expenses == null)
            this.expenses = new ArrayList<>();

        this.expenses.add(expense);
    }

    @Override
    public void updateBookOnTransactionCommit(Transaction transaction) {
        Expense expense = transaction.expense;
        addExpense(expense);
    }
}
