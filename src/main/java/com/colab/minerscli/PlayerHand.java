package com.colab.minerscli;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayerHand {
    private List<Card> hand;
    public PlayerHand() {
        hand = new ArrayList<>();
    }
    //*Is used by Player objects to draw deck.
    public void addCard(Card card) {
        hand.add(card);
    }
    //*Is used by Player object to move deck to the board.
    public void removeCard(Card card) {
        hand.remove(card);
    }

    //*Get
    public List<Card> getHand() {
        //return new ArrayList<>(deck); 1. copy of the list
        return hand; // 2. Reference to the list in memory
    }

    public Card selectCard() {
        Scanner scanner = new Scanner(System.in); // We should probably make a userinput class later.
        int cardIndex = 0;
        while (true) {
            System.out.print("Select a card by entering its number: ");
            try {
                cardIndex = Integer.parseInt(scanner.nextLine());
                if (cardIndex < 1 || cardIndex > hand.size()) {
                    System.out.println("Invalid card number. Please try again.");
                } else {
                    break; // Valid selection
                }
            } catch (NumberFormatException e) {
                System.out.println("That's not a valid number. Please try again.");
            }
        }
        return hand.get(cardIndex - 1); // Adjust for 0-based indexing
    }

    public void printCards() {
        int index = 1;
        for (Card card : hand) {
            System.out.printf("[%d] %-30s | Pressure: %-2d\n", index++, card.getName(), card.getPressure());
        }
    }



}