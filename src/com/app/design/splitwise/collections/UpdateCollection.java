package com.app.design.splitwise.collections;

import com.app.design.splitwise.models.Transaction;

public interface UpdateCollection {
    public void updateCollectionOnTransactionCommit(Transaction transaction);
}
