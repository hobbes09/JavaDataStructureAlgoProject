package com.app.design.splitwise.splitters;

import com.app.design.splitwise.models.Borrow;
import com.app.design.splitwise.models.Expense;
import com.app.design.splitwise.models.User;

import java.util.ArrayList;

public class EqualSplittingStrategy implements SplitStrategy {
    @Override
    public ArrayList<Borrow> splitExpense(Expense expense, ArrayList<User> borrowers) {

        ArrayList<Borrow> borrowSplits = new ArrayList<>();
        EqualSplittingFunction equalSplittingFunction = new EqualSplittingFunction();

        for (User borrower : borrowers) {
            Borrow borrow = new Borrow();
            borrow.borrower = borrower;
            borrow.expense = expense;
            borrow.borrowedAmount = equalSplittingFunction.getUserBorrowAmountFromExpense(expense, borrower, borrowers);
            borrowSplits.add(borrow);
        }
        return borrowSplits;
    }
}
