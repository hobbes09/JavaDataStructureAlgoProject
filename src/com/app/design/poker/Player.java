package com.app.design.poker;

public class Player {

    private String name;
    private Hand hand;
    private int totalMoney;
    private int moneyInGame;
    private boolean isFolded;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getMoneyInGame() {
        return moneyInGame;
    }

    public void setMoneyInGame(int moneyInGame) {
        this.moneyInGame = moneyInGame;
    }

    public boolean isFolded() {
        return isFolded;
    }

    public void setFolded(boolean folded) {
        isFolded = folded;
    }
}
