package com.colab.minerscli;

import java.util.Random;
import java.util.Scanner;

public class GameEngine {
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    private static final Scanner scanner = new Scanner(System.in);

    public GameEngine(){}

    public GameEngine(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1; // Gjorde om så att konstruktören settar default player1 som börjar
        Board board = new Board();
        startGame(board); //See comment in startGame
    }

    private void switchCurrentPlayer() {
        // Switches the currentPlayer between player1 and player2
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    //By passing board into startGame I'm making it accessible to change throughout the progress of the game.
    public void startGame(Board board){
        //We got names, decks and a hand (Player's constructor)
        //Board has Diamonds (Board Constructor)
        //TODO: Let's give an introduction in text and a first view of the board. Prompt Player 1 to be the one by the screen.
        boolean gameActive = true;
        while (gameActive) {
            System.out.println("It's " + currentPlayer.getName() + "'s turn. Make sure the other player can't see the screen!");
            System.out.println("Press Enter when you're ready!");
            scanner.nextLine();

            // Print the current player's hand
            System.out.println("You've drawn the following 5 cards " + currentPlayer.getName() + ", here's your hand:");
            currentPlayer.getPlayerHand().printCards();

            Card selectedCard = currentPlayer.getPlayerHand().selectCard();
            System.out.println("You've selected: " + selectedCard);

            // 1. Ask player to choose between "bottom left," "bottom middle," and "bottom right".
            // 2. Afterwards, ask where in the 2x2 square to place selected card.
            System.out.println("Choose where you'd like to place your card.");
            board.showBoard();
            board.askForPlacement(selectedCard.getPressure());
            // Player1 has now placed their card. Make player2 turn to place theirs...

            //Step 1 is to make currentPlayer player 2.
            switchCurrentPlayer();




            /////////////////////////////
            System.out.println("Ok, now it's " + currentPlayer.getName() + "'s turn. Make sure the other player can't see the screen!");
            System.out.println("Press Enter when you're ready!");
            scanner.nextLine();

            //TODO: Repeat the turn for the board from the perspective of the second player (it should look the same, but influence the reversed board)



            //TODO: Carro söndags
            // Mechanism to switch players?
            //currentPlayer = (currentPlayer == player1) ? player2 : player1;

            //Check "win conditions"
            Rules.checkIfPlayerGetsADiamond(board, player1, player2);
            Rules.checkIfDiamondIsDestroyed(board, player1, player2);
            Rules.checkWinConditionsIfAllDiamondsAreGone(board, player1, player2);



            //TODO: Each player draws a card before every turn after turn 1

            //WIN CONDITIONS:////////////////////////////////////////////////////////////////////////////////////////////

            //Check win conditions (if a player has 21 points within one field on their side, they get the diamond responding to that field,
            //if they have more than 21, the diamond gets destroyed and they can change the placement of miners working on that field to another field). [Based on the comparison of the Diamonds density and the sum of fields (methods in Board)
            //if they have an equal amount of diamonds or none at all (which still is equal) the one with the least pressure on the field wins.
            //Game either ends or continues

        }
    }
}