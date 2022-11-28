package com.app.design.splitwise.splitters;

import com.app.design.splitwise.models.Expense;
import com.app.design.splitwise.models.ExpenseAmount;
import com.app.design.splitwise.models.User;

import java.util.ArrayList;

public interface SplittingFunction {

    public ExpenseAmount getUserBorrowAmountFromExpense(Expense expense, User user, ArrayList<User> borrowers);
}
