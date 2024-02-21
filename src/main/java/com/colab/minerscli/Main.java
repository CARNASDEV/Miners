package com.colab.minerscli;

import java.util.List;

public class Main {
    public static void main(String[] args) {
       //Menu menu = new Menu();
        //Menu.showMenu();


        Player player1 = new Player("Bib");
        Player player2 = new Player("Bob");
        GameEngine gameEngine = new GameEngine(player1, player2);
        Board board = new Board();
        gameEngine.startGame(board, player1, player2);



        /*
        PlayerHand playerHand = new PlayerHand();
// Add some cards to the player's hand
        playerHand.getCards().add(new Card());

// Now we can get the cards in the player's hand
        List<Card> cardsInHand = playerHand.getCards();

// Modify the cardsInHand list
        cardsInHand.remove(0);

// Since cardsInHand is a reference to the same list as playerHand.getCards(),
// the modification also affects playerHand.getCards()
        System.out.println(playerHand.getCards().size()); // This will print 0

    }
    */

    }
}