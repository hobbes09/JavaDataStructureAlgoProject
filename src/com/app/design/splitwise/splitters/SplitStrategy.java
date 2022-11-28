package com.app.design.splitwise.splitters;

import com.app.design.splitwise.models.Borrow;
import com.app.design.splitwise.models.Expense;
import com.app.design.splitwise.models.User;

import java.util.ArrayList;

public interface SplitStrategy {

    public ArrayList<Borrow> splitExpense(Expense expense, ArrayList<User> borrowers);

}
