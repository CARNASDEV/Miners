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
    

    public void drawCard() {
        if (!(this.deck.cards.isEmpty())) {
        
            playerHand.addCard(deck.cards.remove(0));
        }

    }

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
