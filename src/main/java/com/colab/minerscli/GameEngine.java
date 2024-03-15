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
        Board boardHolo = new Board();
        startGame(board, boardHolo, player1, player2); //See comment in startGame
    }

// Player 1 goes always first (0=0), there is no option for Player 2 to have more rounds.
    private Player switchCurrentPlayer(Player player1, Player player2) {
        return (player1.getRoundsPlayed() == player2.getRoundsPlayed()) ? player1 : player2;
    }

    //By passing board into startGame I'm making it accessible to change throughout the progress of the game.
    public void startGame(Board board, Board boardHolo, Player player1, Player player2) {
        boolean gameActive = true;
        while (gameActive) {

            gameTurn(board, boardHolo, switchCurrentPlayer(player1, player2));
            gameTurn(board, boardHolo, switchCurrentPlayer(player1, player2));
            //some conditions (Rules)
            board.placeCardInArea(player1);
            board.placeCardInArea(player2);

            player1.drawCard();
            player2.drawCard();



        }

    }

    public void gameTurn(Board board, Board boardHolo, Player currentPlayer) {

        System.out.println("It's " + currentPlayer.getName() + "'s turn. Make sure the other player can't see the screen!");
        System.out.println("Press Enter when you're ready!");
        scanner.nextLine();

        boardHolo.showBoard();

        // Print the current player's hand
        System.out.println("You've drawn cards " + currentPlayer.getName() + ", here's your hand:");
        currentPlayer.getPlayerHand().printCards();

        Card selectedCard = currentPlayer.getPlayerHand().selectCard();
        System.out.println("You've selected: " + selectedCard);


        // 1. Ask player to choose between "bottom left," "bottom middle," and "bottom right".
        // 2. Afterwards, ask where in the 2x2 square to place selected card.
        System.out.println("Choose where you'd like to place your card.");
        board.showBoard();
        currentPlayer.setPocket(board.askForPlacement(selectedCard.getPressure(), currentPlayer));
        //place to imaginary board for Rules
        Rules.checkIfPlayerGetsADiamond(board, player1, player2);
        Rules.checkIfDiamondIsDestroyed(board, player1, player2);
        Rules.checkWinConditionsIfAllDiamondsAreGone(board, player1, player2);


    }
}