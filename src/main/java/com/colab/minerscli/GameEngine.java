package com.colab.minerscli;

import java.util.Scanner;

public class GameEngine {
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    private static final Scanner scanner = new Scanner(System.in);

    public GameEngine() {
    }

    public GameEngine(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        //this.currentPlayer = player1; // Gjorde om så att konstruktören settar default player1 som börjar
        Board board = new Board();
        startGame(board, player1, player2); //See comment in startGame
    }


    private Player switchCurrentPlayer(Player player1, Player player2) {
        return (currentPlayer == player1) ? player2 : player1;
    }

    //By passing board into startGame I'm making it accessible to change throughout the progress of the game.
    public void startGame(Board board, Player player1, Player player2) {
        boolean gameActive = true;
        while (gameActive) {

            gameLoop(board, switchCurrentPlayer(player1, player2));
            player1.drawCard();
            player2.drawCard();
        }

    }

    public void gameLoop(Board board, Player currentPlayer) {

        System.out.println("It's " + currentPlayer.getName() + "'s turn. Make sure the other player can't see the screen!");
        System.out.println("Press Enter when you're ready!");
        scanner.nextLine();

        // Print the current player's hand
        System.out.println("You've drawn cards " + currentPlayer.getName() + ", here's your hand:");
        currentPlayer.getPlayerHand().printCards();

        Card selectedCard = currentPlayer.getPlayerHand().selectCard();
        System.out.println("You've selected: " + selectedCard);

        // 1. Ask player to choose between "bottom left," "bottom middle," and "bottom right".
        // 2. Afterwards, ask where in the 2x2 square to place selected card.
        System.out.println("Choose where you'd like to place your card.");
        board.showBoard();
        board.askForPlacement(selectedCard.getPressure());
        // Player1 has now placed their card.



        //Check "win conditions"
        Rules.checkIfPlayerGetsADiamond(board, player1, player2);
        Rules.checkIfDiamondIsDestroyed(board, player1, player2);
        Rules.checkWinConditionsIfAllDiamondsAreGone(board, player1, player2);

        //WIN CONDITIONS:////////////////////////////////////////////////////////////////////////////////////////////
        //Check win conditions (if a player has 21 points within one field on their side, they get the diamond responding to that field,
        //if they have more than 21, the diamond gets destroyed and they can change the placement of miners working on that field to another field). [Based on the comparison of the Diamonds density and the sum of fields (methods in Board)
        //if they have an equal amount of diamonds or none at all (which still is equal) the one with the least pressure on the field wins.
        //Game either ends or continues
    }
}