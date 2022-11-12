package com.app.ex;

import com.app.Solution;

import java.util.ArrayList;
import java.util.Scanner;

public class Game implements Solution {

    CommunityChest chest;
    ArrayList<Player>  players;

    private ArrayList<Card> deckCards;
    Scanner input = new Scanner(System.in);

    public Game() {

        // Create deck
        deckCards = Deck.getShuffledCards();

        // Declare small blind peron randomly

        // Create Players
         // Take name, total money

    }

    @Override
    public void execute() {

        while (chest.getGameState() != GameState.FULL) {

            // raise Money
            raiseMoneyForGame();

            // Reveal card as per game state

        }

    }

    private void raiseMoneyForGame() {

        int i = 0;

//        while (consensusNoAchieved(players)) {
//
//            Player p = players.get(i % players.size());
//
//
//            i++;
//        }
    }


    private int getPlayerDecision(Player player) {
        return 0;
    }
}
