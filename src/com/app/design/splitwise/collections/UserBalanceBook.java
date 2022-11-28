package com.app.design.splitwise.collections;

import com.app.design.splitwise.models.*;

import java.util.HashMap;

/*
Book to maintain all the expenses and the borrowings of an individual
 */
public class UserBalanceBook implements UpdateBook {
    User subjectUser;

    /*
    Map key = Other UserIds
    Map value = Amounts to be collected by subjectUser from other users, per currency type
    This is the track the amounts a user is expected to receive from others.

    This is the result of an aggregation, where expenses from multiple transactions with another user is
    aggregated to create the overall lumsum expediture made on another user. The other user can either exist on
    expendituresOnOtherUsers or borrowingsFromOtherUsers, but not on both.
     */
    HashMap<String, HashMap<Currency, ExpenseAmount>> expendituresOnOtherUsers;

    /*
    Map key = Other UserIds
    Map value = Amounts to be paid by subjectUser to other users, per currency type
    This is the track the amounts a user is expected to pay to others.

    This is the result of an aggregation, where expenses from multiple transactions with another user is
    aggregated to create the overall lumsum borrow made from another user. The other user can either exist on
    expendituresOnOtherUsers or borrowingsFromOtherUsers, but not on both.
     */
    HashMap<String, HashMap<Currency, ExpenseAmount>> borrowingsFromOtherUsers;

    public UserBalanceBook(User subjectUser) {
        this.subjectUser = subjectUser;
        this.expendituresOnOtherUsers = new HashMap<>();
        this.borrowingsFromOtherUsers = new HashMap<>();
    }

    @Override
    public void updateBookOnTransactionCommit(Transaction transaction) {
        if (transaction.expense.payer.getId() == subjectUser.getId()) {
            updateBookOnTransactionCommitAsPayer(transaction);
        } else {
            updateBookOnTransactionCommitAsBorrower(transaction);
        }
    }

    /*
    This is the scenario where the subjectUser is the borrower.
    In this case he records the amount6 he has borrowed from the payer.
    Additionally. in case he had previous transactions with the payer,
    we rebalance both the books, where the external user is the payer here.
     */
    private void updateBookOnTransactionCommitAsBorrower(Transaction transaction) {
        for (Borrow borrow: transaction.individualBorrows) {
            if (borrow.borrower.getId() == subjectUser.getId()) {
                // Get borrowed amount to be updated
                ExpenseAmount borrowedAmount = borrow.borrowedAmount;

                // Get existing borrowings from this payer
                HashMap<Currency, ExpenseAmount> existingBorrowedAmountFromPayer = borrowingsFromOtherUsers
                        .getOrDefault(borrow.expense.payer.getId(), new HashMap<>());
                ExpenseAmount existingBorrowedAmountFromPayerOfTxnCurrency = existingBorrowedAmountFromPayer.get(borrowedAmount.currency);

                // Add to existing borrowings from this payer
                if (existingBorrowedAmountFromPayerOfTxnCurrency == null){
                    existingBorrowedAmountFromPayer.put(borrowedAmount.currency, borrowedAmount);
                } else {
                    existingBorrowedAmountFromPayer.put(borrowedAmount.currency,
                            existingBorrowedAmountFromPayerOfTxnCurrency.add(borrowedAmount));
                }
                borrowingsFromOtherUsers.put(borrow.expense.payer.getId(), existingBorrowedAmountFromPayer);

                // Rebalance books for all lendings and borrowings by subject to payer
                crossBalanceExpendituresAndBorrowingsForUser(borrow.expense.payer);
            }
        }
    }

    private void updateBookOnTransactionCommitAsPayer(Transaction transaction){
        for (Borrow borrow : transaction.individualBorrows) {
            if (borrow.borrower.getId() == subjectUser.getId()) {
                // Payer cannot borrow from himself. Its a normal expense
                continue;
            }
            // Get borrowed amount to be collected
            ExpenseAmount borrowedAmount = borrow.borrowedAmount;

            // Get existing borrowings from this payer
            HashMap<Currency, ExpenseAmount> existingExpenditureAmountOnBorrower = expendituresOnOtherUsers
                    .getOrDefault(borrow.borrower.getId(), new HashMap<>());
            ExpenseAmount existingExpenditureAmountFromBorrowerOfTxnCurrency = existingExpenditureAmountOnBorrower.get(borrowedAmount.currency);

            // Add to existing borrowings from this payer
            if (existingExpenditureAmountFromBorrowerOfTxnCurrency == null){
                existingExpenditureAmountOnBorrower.put(borrowedAmount.currency, borrowedAmount);
            } else {
                existingExpenditureAmountOnBorrower.put(borrowedAmount.currency,
                        existingExpenditureAmountFromBorrowerOfTxnCurrency.add(borrowedAmount));
            }
            expendituresOnOtherUsers.put(borrow.borrower.getId(), existingExpenditureAmountOnBorrower);
            crossBalanceExpendituresAndBorrowingsForUser(borrow.borrower);
        }
    }

    private void crossBalanceExpendituresAndBorrowingsForUser(User user) {

        HashMap<Currency, ExpenseAmount> existingExpenditure = expendituresOnOtherUsers.get(user.getId());
        HashMap<Currency, ExpenseAmount> existingBorrow = borrowingsFromOtherUsers.get(user.getId());

        if (existingExpenditure == null || existingBorrow == null){
            return;
        }
        for (Currency currency: Currency.values()) {
            ExpenseAmount lent = existingExpenditure.get(currency);
            ExpenseAmount borrowed = existingBorrow.get(currency);
            if (lent == null || borrowed == null)
                continue;

            existingExpenditure.remove(currency);
            existingBorrow.remove(currency);
            ExpenseAmount balance = lent.difference(borrowed);

            if (!lent.isEqual(borrowed)){
                if (lent.isGreaterThan(borrowed)) {
                    existingExpenditure.put(currency, balance);
                } else {
                    existingBorrow.put(currency, balance);
                }
            }

            expendituresOnOtherUsers.put(user.getId(), existingExpenditure);
            borrowingsFromOtherUsers.put(user.getId(), existingBorrow);
        }
    }

}
