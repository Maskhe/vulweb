//package cn.bestsec.vulweb.service.impl;
//
//import cn.bestsec.vulweb.service.NoSQLInjectionService;
//import com.mongodb.client.*;
//import com.mongodb.client.result.DeleteResult;
//import org.bson.BsonDocument;
//import org.bson.Document;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//
///**
// * @author hjx
// * @since 2023/1/10
// */
//@Service
//public class NoSQLInjectionServiceImpl implements NoSQLInjectionService {
//
//    @Value("${mongo.url}")
//    private String mongoServer;
//
//    @Value("${mongo.db}")
//    private String dbName;
//
//    @Value("${mongo.collection}")
//    private String collectionName;
//
//    @Override
//    public String query(String value) {
//        ArrayList<String> result = new ArrayList<>();
//        try (MongoClient mongoClient = MongoClients.create(this.mongoServer)) {
//            // 选择数据库
//            MongoDatabase database = mongoClient.getDatabase(this.dbName);
//
//            // 选择集合
//            MongoCollection<Document> collection = database.getCollection(this.collectionName);
//
//            // 构建查询条件
//            Document query = Document.parse(value);
//            // 执行查询
//            FindIterable<Document> documents = collection.find(query);
//
//            // 遍历查询结果
//            try (MongoCursor<Document> cursor = documents.iterator()) {
//                while (cursor.hasNext()) {
//                    Document document = cursor.next();
//                    result.add(document.toJson());
//                }
//            }
//        }
//        return result.toString();
//    }
//
//    @Override
//    public String queryNotVul(String query) {
//        ArrayList<String> result = new ArrayList<>();
//        try (MongoClient mongoClient = MongoClients.create(this.mongoServer)) {
//            MongoDatabase database = mongoClient.getDatabase(this.dbName);
//            MongoCollection<Document> collection = database.getCollection(this.collectionName);
//            Document queryDocument = new Document();
//            queryDocument.put("name", query);
//            // 执行查询
//            FindIterable<Document> documents = collection.find(queryDocument);
//
//            // 遍历查询结果
//            try (MongoCursor<Document> cursor = documents.iterator()) {
//                while (cursor.hasNext()) {
//                    Document document = cursor.next();
//                    result.add(document.toJson());
//                }
//            }
//
//        }
//        return result.toString();
//    }
//
//
//    @Override
//    public String delete(String filter) {
//        DeleteResult result;
//        try (MongoClient mongoClient = MongoClients.create(this.mongoServer)) {
//            // 选择数据库
//            MongoDatabase database = mongoClient.getDatabase(this.dbName);
//
//            // 选择集合
//            MongoCollection<Document> collection = database.getCollection(this.collectionName);
//
//            // 构建查询条件
//            Document query = Document.parse(filter);
//            // 执行查询
//            result = collection.deleteOne(query);
//
//        }
//        return result.toString();
//    }
//
//    @Override
//    public String distinct(String filter) {
//        String result;
//        try (MongoClient mongoClient = MongoClients.create(this.mongoServer)) {
//            // 选择数据库
//            MongoDatabase database = mongoClient.getDatabase(this.dbName);
//
//            // 选择集合
//            MongoCollection<Document> collection = database.getCollection(this.collectionName);
//
//            // 构建查询条件
//            Document query = Document.parse(filter);
//            // 执行查询
//            result = collection.distinct("test", query, String.class).first();
//
//        }
//        return result;
//    }
//
//    @Override
//    public String runCommand(String key, String value) {
//        String result;
//        try (MongoClient mongoClient = MongoClients.create(this.mongoServer)) {
//            // 选择数据库
//            MongoDatabase database = mongoClient.getDatabase(this.dbName);
//
//            // 选择集合
//            MongoCollection<Document> collection = database.getCollection(this.collectionName);
//
//            // 构建查询条件
//            Document query = new Document(key, value);
//            // 执行查询
//            Document documentResult = database.runCommand(query);
//
//            return documentResult.toString();
//        }
//    }
//}
