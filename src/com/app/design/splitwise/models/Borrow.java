package com.app.design.splitwise.models;

/*
Borrow refers to a single entry of debt expense occurred per individual when they borrow from another individual
 */
public class Borrow {
    public Expense expense;
    public User borrower;
    public ExpenseAmount borrowedAmount;
}
