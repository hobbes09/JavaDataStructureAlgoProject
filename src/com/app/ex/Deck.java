package com.app.ex;

import java.util.ArrayList;
import java.util.Collections;

// Immutable class
public class Deck {
    private static ArrayList<Card> cards = new ArrayList();

    private Deck() {
        // Initialize here
    }

    public ArrayList<Card> getDeckCards() {
        return cards;
    }
    public static ArrayList<Card> getShuffledCards() {
        Collections.shuffle(cards);
        return cards;
    }
}
