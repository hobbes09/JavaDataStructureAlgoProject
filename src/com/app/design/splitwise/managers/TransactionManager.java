package com.app.design.splitwise.managers;

import com.app.design.splitwise.collections.UserCollection;
import com.app.design.splitwise.models.InputModel;
import com.app.design.splitwise.models.Transaction;
import com.app.design.splitwise.collections.UserBalanceBooksCollection;
import com.app.design.splitwise.collections.UserBorrowingsBooksCollection;
import com.app.design.splitwise.collections.UserExpensesBooksCollection;

import java.util.ArrayList;
import java.util.List;

public class TransactionManager implements TransactionCommitter{

    UserExpensesBooksCollection userExpensesBooksCollection;
    UserBorrowingsBooksCollection userBorrowingsBooksCollection;
    UserBalanceBooksCollection userBalanceBooksCollection;
    UserCollection userCollection;

    List<Transaction> allTransactions;

    public void addNewTransaction(InputModel input) {
        Transaction transaction = Transaction.createTransactionFromInput(input);
        onTransactionCommit(transaction);
    }

    @Override
    public void onTransactionCommit(Transaction transaction) {
        if (userCollection == null) {
            userCollection = new UserCollection();
            allTransactions = new ArrayList<>();
            userExpensesBooksCollection = new UserExpensesBooksCollection();
            userBorrowingsBooksCollection = new UserBorrowingsBooksCollection();
            userBalanceBooksCollection = new UserBalanceBooksCollection();
        }

        allTransactions.add(transaction);
        userCollection.updateCollectionOnTransactionCommit(transaction);
        userExpensesBooksCollection.updateCollectionOnTransactionCommit(transaction);
        userBorrowingsBooksCollection.updateCollectionOnTransactionCommit(transaction);
        userBalanceBooksCollection.updateCollectionOnTransactionCommit(transaction);
    }
}
