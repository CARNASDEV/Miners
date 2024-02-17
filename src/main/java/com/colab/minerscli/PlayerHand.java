package com.colab.minerscli;

import java.util.List;
import java.util.ArrayList;

public class PlayerHand { //The cards that the player plays with
    //Is gonna be an array of card objects.
    //hands need to have 5 cards and they have to be visible ONLY to the player
    //Shown only when its the specific players turn
    //cards need to be able to be added, removed to and from deck

    private List<Card> cards;

    public PlayerHand() {
        cards = new ArrayList<>();
    }


    public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }

    //We need to decide of we want to return a reference to the cars list or just a copy of the list
    public List<Card> getCards() {
        //return new ArrayList<>(cards); 1. copy of the list
        return cards; // 2. Reference to the list in memory
    }

    //Card class needs to have a toString method or else the cards will be printed here.
    public void printCards() {
        for (Card card : cards) {
            System.out.println(card);


            //System.out.println(card.getName());
            //System.out.println(card.getId());
            //System.out.println(card.getPressure());
        }
    }


}