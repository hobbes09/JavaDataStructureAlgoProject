package com.app.design.splitwise.models;

import com.app.design.splitwise.splitters.SplitStrategy;

import java.util.ArrayList;

/*
All expenses here are assumed to be equally borrowed by all members of the group. The borrower list is the entire group
 */
public class GroupTransaction extends Transaction{

    Group group;

    protected GroupTransaction(Expense expense, ArrayList<Borrow> individualBorrows, SplitStrategy splitStrategy, Group group) {
        super(expense, individualBorrows, splitStrategy);
        this.group = group;
    }

}
