package com.colab.minerscli;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DeckJSON {
    List<Card> deck;

    public DeckJSON() {
        deck = new ArrayList<>();
        initializeDeckFromJSON("resrc/cards.json");
    }

    private void initializeDeckFromJSON(String filename) {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename)) {
            if (inputStream == null) {
                System.err.println("Error: Resource not found: " + filename);
                return;
            }
            String json = new String(inputStream.readAllBytes());
            List<Card> parsedCards = CardParser.parseCards(json);
            deck.addAll(parsedCards);
        } catch (IOException e) {
            System.err.println("Error initializing deck from JSON: " + e.getMessage());
            // Log the error or handle it appropriately
        }
    }
}
