package com.colab.minerscli;

import java.util.Random;

public class GameEngine {
    private Player player1;
    private Player player2;

    public GameEngine(){}
    
    public GameEngine(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        Board board = new Board();
        turnOne(tossCoin(Player player1, Player player2));
    }

    public static Player tossCoin(Player player1, Player player2) {
        // Randomly generate 0 or 1
        Random random = new Random();
        int result = random.nextInt(2);

        // If result is 0, it's heads. If result is 1, it's tails.
        if (result == 0) {
            return "player1";
        } else {
            return "player2";
        }
    }

    public static void turnOne(Player player){
        //Need to change the PlayerHand and Deck to ArrayLists, so we can use the better methods.
        //We need to figure out how to first draw 5 cards into the PlayerHand and then draw one in the beginning of each turn
        //The turn of each player consists of picking a Card object from PlayerHand and placing it on the board (using methods in the Board)
        //Check win conditions (if a player has 21 points within one field on their side, they get the diamond responding to that field, 
        //if they have more than 21, the diamond gets destroyed and they can change the placement of miners working on that field to another field). [Based on the comparison of the Diamonds density and the sum of fields (methods in Board)
        //if they have an equal amount of diamonds or none at all (which still is equal) the one with the least pressure on the field wins. 
        //Game either ends or continues


    }

    }







    //TODO: Skapa två spelare (Dem måste ha varsin deck (25) + hand(5))

    //TODO:: Skapa en board (Kommer ha 3 diamander med density 21)

    //TODO: Nu börjar en turn. Avgör vem som börjar.

    /////////////////////////////////////////////////////////////////
    //TODO: 1st turn: Varje spelare drar ett kort från deck.
    //TODO: Varje spelare måste lägga ett kort någonstans på sin planhalva
    //TODO: Efter man lagt 1 kort kollas conditions.
    //////////////////////////////////////////////////////



}
