package com.colab.minerscli;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckJSON {
    private List<Card> cardPool;
    public List<Card> deck;

    public DeckJSON() {
        cardPool = new ArrayList<>();
        initializeCardPool("resrc/cards.json");
        this.deck = generateDeck();
    }

    private void initializeCardPool(String filename) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename)) {
            if (inputStream == null) {
                System.err.println("Error: Resource not found: " + filename);
                return;
            }
            ObjectMapper objectMapper = new ObjectMapper();
            cardPool = objectMapper.readValue(inputStream, new TypeReference<List<Card>>(){});
        } catch (IOException e) {
            System.err.println("Error initializing card pool from JSON: " + e.getMessage());
        }
    }

    public List<Card> generateDeck() {
        List<Card> deck = new ArrayList<>();
        Collections.shuffle(cardPool);
        for (int i = 0; i < 25; i++) {
            deck.add(cardPool.get(i));
        }
        return deck;
    }
}
