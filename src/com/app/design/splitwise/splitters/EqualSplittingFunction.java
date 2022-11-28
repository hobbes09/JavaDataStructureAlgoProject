package com.app.design.splitwise.splitters;

import com.app.design.splitwise.models.Expense;
import com.app.design.splitwise.models.ExpenseAmount;
import com.app.design.splitwise.models.User;

import java.util.ArrayList;

public class EqualSplittingFunction implements SplittingFunction {
    @Override
    public ExpenseAmount getUserBorrowAmountFromExpense(Expense expense, User user, ArrayList<User> borrowers) {
        ExpenseAmount borrowedAmount = new ExpenseAmount();
        borrowedAmount.currency = expense.expenseAmount.currency;
        borrowedAmount.amountValue = (borrowers.size() == 0) ? 0: expense.expenseAmount.amountValue / borrowers.size();
        return borrowedAmount;
    }
}
