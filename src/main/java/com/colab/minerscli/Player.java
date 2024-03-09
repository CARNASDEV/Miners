package com.colab.minerscli;


import java.util.List;

public class Player {
    private String name;
    private DeckJSON dj;
    private List<Card> deck;
    private PlayerHand playerHand;
    private int diamondsRewarded = 0;


    public Player(String name) {
        this.name = name;
        dj = new DeckJSON();
        this.deck = dj.generateDeck();
        this.playerHand = new PlayerHand();
        this.diamondsRewarded = 0;
        drawHand();
    }

    public Player(){}

    //Mechanics:
    //* If deck is not empty, a card gets moved to hand.
    public void drawCard() {
        if (!(this.deck.isEmpty())) {
            playerHand.addCard(deck.remove(0));}
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

    public DeckJSON getDeck() {
        return dj;
    }

    public void setDeck(DeckJSON deck) {
        this.dj = deck;
    }

    public PlayerHand getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(PlayerHand playerHand) {
        this.playerHand = playerHand;
    }

    public int getDiamondsRewarded() { return diamondsRewarded; }

    public void setDiamondsRewarded(int diamondsRewarded) {this.diamondsRewarded = diamondsRewarded;}

}
