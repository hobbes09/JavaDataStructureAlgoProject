package com.app.design.poker;

import java.util.ArrayList;

public class CommunityChest {

    ArrayList<Card> communityCards;

    public CommunityChest() {
        this.communityCards = new ArrayList<>();
    }

    public GameState getGameState() {
        switch (communityCards.size()) {
            case 0:
                return GameState.INIT;
            case 3:
                return GameState.PRE_TURN;
            case 4:
                return GameState.PRE_RIVER;
            case 5:
                return GameState.FULL;
            default:
                return GameState.INIT;
        }
    }

}
