package com.app.design.splitwise.collections;

import com.app.design.splitwise.models.Transaction;

public interface UpdateBook {
    public void updateBookOnTransactionCommit(Transaction transaction);
}
