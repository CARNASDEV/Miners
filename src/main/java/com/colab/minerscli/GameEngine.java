package com.colab.minerscli;

import java.util.Random;
import java.util.Scanner;

public class GameEngine {
    private Player player1;
    private Player player2;

    private static final Scanner scanner = new Scanner(System.in);

    public GameEngine(){}
    
    public GameEngine(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        Board board = new Board();
        startGame(board, player1, player2); //See comment in startGame
    }



    //By passing board into startGame I'm making it accessible to change throughout the progress of the game.
    public static void startGame(Board board, Player player1, Player player2){
        //We got names, decks and a hand (Player's constructor)
        //Board has Diamonds (Board Constructor)
        //TODO: Let's give an introduction in text and a first view of the board. Prompt Player 1 to be the one by the screen.
        boolean gameActive = true;

        while (gameActive) {
            // Print board p1POV (default)
            board.showBoard();
            System.out.println("It's "+player1.getName()+"'s turn. Make sure "+player2.getName()+" can't see the screen!");
            System.out.println("Press Enter when you're ready!");
            scanner.nextLine();

            board.showBoard();
            System.out.println(player1.getPlayerHand().getHand()); //funkar???


            //TODO: Mechanism to pick a card from hand
            //TODO: Mechanism to pick the field on the board
            //TODO: Mechanism to send the chosen card object to the right field on the board.


            //Check "win conditions"
            Rules.checkIfPlayerGetsADiamond(board, player1, player2);
            Rules.checkIfDiamondIsDestroyed(board, player1, player2);
            Rules.checkWinConditionsIfAllDiamondsAreGone(board, player1, player2);


            //TODO: Prompt player 1 to give the computer to player 2 and ask for an enter when ready
            //TODO: Repeat the turn for the board from the perspective of the second player (it should look the same, but influence the reversed board)
            //TODO: Each player draws a card before every turn after turn 1

            //WIN CONDITIONS:////////////////////////////////////////////////////////////////////////////////////////////

            //Check win conditions (if a player has 21 points within one field on their side, they get the diamond responding to that field,
            //if they have more than 21, the diamond gets destroyed and they can change the placement of miners working on that field to another field). [Based on the comparison of the Diamonds density and the sum of fields (methods in Board)
            //if they have an equal amount of diamonds or none at all (which still is equal) the one with the least pressure on the field wins.
            //Game either ends or continues

        }
    }
}