package org.example;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.telegram.telegrambots.meta.api.objects.Document;

public class MongoConnection {

    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private MongoCollection<Document> collection;

    public MongoConnection(String host, int port, String databaseName, String collectionName) {
        mongoClient = new MongoClient(host, port);
        mongoDatabase = mongoClient.getDatabase(databaseName);
//        collection = mongoDatabase.getCollection(collectionName);
    }

    public void insert(Document document) {
        collection.insertOne(document);
    }

    public void update(Document filter, Document update) {
//        collection.updateOne(filter, update);
    }

    public MongoCollection<Document> getCollection() {
        return collection;
    }

    public void close() {
        mongoClient.close();
    }
}

