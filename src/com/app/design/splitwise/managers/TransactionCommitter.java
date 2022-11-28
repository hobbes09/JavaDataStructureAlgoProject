package com.app.design.splitwise.managers;

import com.app.design.splitwise.models.Transaction;

public interface TransactionCommitter {

    public void onTransactionCommit(Transaction transaction);
}
