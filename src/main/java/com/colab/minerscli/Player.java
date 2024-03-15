package com.colab.minerscli;


import java.util.List;

public class Player {
    private String name;
    private DeckGenerator deckGenerator;
    private List<Card> deck;
    private PlayerHand playerHand;
    private int diamondsRewarded = 0;
    private int id;
    private int roundsPlayed;
    private Pocket pocket;


    public Player(String name, int id) {
        this.name = name;
        deckGenerator = new DeckGenerator();
        this.deck = deckGenerator.generateDeck();
        this.playerHand = new PlayerHand();
        this.pocket = new Pocket();
        this.diamondsRewarded = 0;
        this.roundsPlayed = 0;
        this.id = id;
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

    public DeckGenerator getDeck() {
        return deckGenerator;
    }

    public void setDeck(DeckGenerator deck) {
        this.deckGenerator = deck;
    }

    public PlayerHand getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(PlayerHand playerHand) {
        this.playerHand = playerHand;
    }

    public int getDiamondsRewarded() { return diamondsRewarded; }

    public void setDiamondsRewarded(int diamondsRewarded) {this.diamondsRewarded = diamondsRewarded;}

    public int getRoundsPlayed() {return roundsPlayed;}

    public void setRoundsPlayed(int roundsPlayed) {this.roundsPlayed = roundsPlayed;}

    public int getId () {return id;}
    public void setId(int id) {this.id = id;}

    public Pocket getPocket () {return pocket;}
    public void setPocket(Pocket pocket) {this.pocket = pocket;}

}
