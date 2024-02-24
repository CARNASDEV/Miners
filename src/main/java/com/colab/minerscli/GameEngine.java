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
        //startGame(board, player1, player2); //See comment in startGame
    }

    public static String tossCoin() {
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

    //By passing board into startGame I'm making it accessible to change throughout the progress of the game.
    public static void startGame(Board board, Player player1, Player player2){
        //player1.drawHand();
        //playerHand.printCards(); // Print the cards after drawing all 5 cards

        //player2.drawHand();
        //player1.drawCard();
        //player1.drawCard();
        //board.showBoardPlayer1Perspective();
        //player1.drawCard();

        boolean gameActive = true;
        boolean isPlayer1Turn = tossCoin().equals("player1");

        while (gameActive) {
            // Print current board state
            if (isPlayer1Turn) {
                board.showBoard();
            } else {
                board.showBoardPlayer2Perspective();
            }

            // For now, let's just end the game after one turn
            gameActive = false;
        }

        //board.showBoardPlayer2Perspective();

        //player 1 board perspective appears
        //player 1 picks a card and places it (we store the choice on the side and change the board after or simultaneously with player 2)
        //player 1 ends the turn
        //player 2 accepts he is at the board
        //player 2 board perspective appears (without seeing what player 1 did) (we flip it)
        //player 2 picks a card and places it (we store the choice on the side and change the board after or simultaneously with player 2)
        //player 2 ends the turn
        //board updates fully 

        //win conditions, if game still on, repeat 


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




