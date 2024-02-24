package com.colab.minerscli;



public class Player {
    private String name;
    private Deck deck;
    private PlayerHand playerHand;

    public Player(String name) {
        this.name = name;
        this.deck = new Deck(); 
        this.playerHand = new PlayerHand(); 
    }

    public Player(){}

    //Mechanics:
    //* If deck is not empty, a card gets moved to hand.
    public void drawCard() {
        if (!(this.deck.deck.isEmpty())) {
            playerHand.addCard(deck.deck.remove(0));}
    }

    //*Draws 5 deck in the beggining of the game.
    public void drawHand(){
        for (int i = 0; i <= 4; i++) {
            drawCard();
    }
}

    //GETSET:

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public PlayerHand getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(PlayerHand playerHand) {
        this.playerHand = playerHand;
    }
}
