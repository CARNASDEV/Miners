package com.colab.minerscli;

import java.util.List;
import java.util.ArrayList;

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

    public void printCards() {
        for (Card card : hand) {
            System.out.println(card);
        }
    }


}