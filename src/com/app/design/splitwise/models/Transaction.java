package com.app.design.splitwise.models;

import com.app.design.splitwise.splitters.EqualSplittingStrategy;
import com.app.design.splitwise.splitters.SplitStrategy;
import com.app.design.splitwise.splitters.SplittingStrategies;

import java.util.ArrayList;

/*
Transaction refers to a single line item that the payer enters after the payment to be entered in the balance books
 */
public class Transaction {
    public Expense expense;
    public ArrayList<Borrow> individualBorrows;
    public SplitStrategy splitStrategy;

    protected Transaction() {
    }

    protected Transaction(Expense expense, ArrayList<Borrow> individualBorrows, SplitStrategy splitStrategy) {
        this.expense = expense;
        this.individualBorrows = individualBorrows;
        this.splitStrategy = splitStrategy;
    }

    public static Transaction createTransactionFromInput(InputModel input) {

        Expense expense1 = new Expense();
        expense1.expenseAmount = input.expenseAmount;
        expense1.title = input.title;
        expense1.description = input.description;
        expense1.payer = input.payer;

        Transaction transaction = new Transaction();
        transaction.expense = expense1;
        transaction.splitStrategy = transaction.getSplitStrategyFromInput(input.splittingStrategyName);
        transaction.individualBorrows = transaction.splitStrategy.splitExpense(expense1, input.borrowers);
        return transaction;
    }

    public SplitStrategy getSplitStrategyFromInput(SplittingStrategies splittingStrategies) {
        if (splittingStrategies == SplittingStrategies.EQUAL) {
            return new EqualSplittingStrategy();
        }
        return new EqualSplittingStrategy();
    }

}
