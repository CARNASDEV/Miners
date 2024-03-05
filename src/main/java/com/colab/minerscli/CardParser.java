package com.colab.minerscli;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class CardParser {
    public static List<Card> parseCards(String json) {
        List<Card> cards = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Card[] cardArray = objectMapper.readValue(json, Card[].class);
            cards.addAll(List.of(cardArray));
        } catch (JsonProcessingException e) {
            System.err.println("Error parsing JSON: " + e.getMessage());
        }
        return cards;
    }
}
