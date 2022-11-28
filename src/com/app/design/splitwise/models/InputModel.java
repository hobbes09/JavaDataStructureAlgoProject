package com.app.design.splitwise.models;

import com.app.design.splitwise.splitters.SplittingStrategies;

import java.util.ArrayList;

public class InputModel {
    public ExpenseAmount expenseAmount;
    public String title;
    public String description;
    public User payer;
    public ArrayList<User> borrowers;
    public SplittingStrategies splittingStrategyName;
}
