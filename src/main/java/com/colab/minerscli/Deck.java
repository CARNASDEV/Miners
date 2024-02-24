package com.colab.minerscli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Deck {
    public List<Card> cards; // Change from array to ArrayList

    public Deck() {
        cards = new ArrayList<>(); // Initialize as ArrayList
        initializeDeckFromDatabase();
    }

    private void initializeDeckFromDatabase() {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("MinersDB");
            MongoCollection<Document> collection = database.getCollection("CardCollection");

            // Retrieve 50 random documents
            List<Document> randomDocuments = collection.aggregate(Arrays.asList(
                    new Document("$sample", new Document("size", 50))
            )).into(new ArrayList<>());

            Set<ObjectId> uniqueIds = new HashSet<>();
            Random random = new Random();

            // Generate 25 unique random IDs
            while (uniqueIds.size() < 25) {
                // Get a random index to select a document
                int randomIndex = random.nextInt(randomDocuments.size());
                Document randomDocument = randomDocuments.get(randomIndex);

                // Extract ID from the document
                ObjectId id = randomDocument.getObjectId("_id");

                // Check if the ID is unique
                if (!uniqueIds.contains(id)) {
                    uniqueIds.add(id);

                    // Extract other card information
                    String name = randomDocument.getString("name");
                    int pressure = randomDocument.getInteger("pressure");

                    // Create the Card object and add to ArrayList
                    cards.add(new Card(name, pressure));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
