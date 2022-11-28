package com.app.design.splitwise.models;

/*
 ExpenseAmount refer to the transaction amount in each transaction
 */
public class ExpenseAmount {
    public Currency currency;
    public float amountValue;

    public ExpenseAmount add(ExpenseAmount another) {
        ExpenseAmount balance = new ExpenseAmount();
        if (currency == another.currency) {
            balance.currency = currency;
            balance.amountValue = amountValue + another.amountValue;
        }
        return balance;
    }

    public ExpenseAmount difference(ExpenseAmount another) {
        ExpenseAmount balance = new ExpenseAmount();
        if (currency == another.currency) {
            balance.currency = currency;
            balance.amountValue = Math.abs(amountValue - another.amountValue);
        }
        return balance;
    }

    public boolean isGreaterThan(ExpenseAmount another) {
        if (currency == another.currency) {
            return amountValue > another.amountValue;
        }
        return false;
    }

    public boolean isEqual(ExpenseAmount another) {
        if (currency == another.currency) {
            return amountValue == another.amountValue;
        }
        return false;
    }
}
