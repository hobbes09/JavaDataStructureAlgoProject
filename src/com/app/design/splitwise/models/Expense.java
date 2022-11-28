package com.app.design.splitwise.models;

/*
Expense refers to the expenditure made by an individual.
Here we are taking the assumption that all expenditures are made by a single individual
The expense amount in such a case will always be positive
 */
public class Expense {
    public ExpenseAmount expenseAmount;
    public String title;
    public String description;
    public User payer;
}
