package com.colab.minerscli;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DeckJSON {
    List<Card> deck;

    public DeckJSON() {
        deck = new ArrayList<>();
        initializeDeckFromJSON("resrc/cards.json");
    }

    private void initializeDeckFromJSON(String filename) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename)) {
            if (inputStream == null) {
                System.err.println("Error: Resource not found: " + filename);
                return;
            }
            deck = CardParser.parseCards(inputStream);
        } catch (IOException e) {
            System.err.println("Error initializing deck from JSON: " + e.getMessage());
        }
    }
}
