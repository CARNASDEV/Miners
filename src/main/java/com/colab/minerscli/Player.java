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

    public Card drawCard(){
        översta kortet från Deck måste skickas till PlayerHand
    
    }

    public PlayerHand drawHand(){


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
