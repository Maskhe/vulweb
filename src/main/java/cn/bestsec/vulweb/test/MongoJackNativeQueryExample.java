//package cn.bestsec.vulweb.test;
//
//
////import cn.bestsec.vulweb.entity.PersonDO;
//import com.mongodb.*;
//import com.mongodb.client.*;
//import com.mongodb.client.MongoClient;
//import org.bson.BsonDocument;
//import org.bson.BsonInt64;
//import org.bson.Document;
//import org.bson.conversions.Bson;
////import com.mongodb.client.MongoClient;
//
//public class MongoJackNativeQueryExample {
//
//    public static void main(String[] args) {
//        // 连接到本地 MongoDB（默认端口）
////        MongoClient mongoClient = new MongoClient("localhost", 27017);
//        final String mongoServer = "mongodb://localhost:27017";
//        final String dbName = "test";
//        final String collectionName = "cl";
//        try (MongoClient mongoClient = MongoClients.create(mongoServer)) {
//            // 选择数据库
//            MongoDatabase database = mongoClient.getDatabase(dbName);
//            MongoCollection<Document> collection = database.getCollection(collectionName);
//            String commandString = "listCollections";
//            String script = "tttt";
////            Bson command = new BsonDocument(commandString, new BsonInt64(1));
//            Bson command = new Document(commandString, 1);
//            Document documentResult = database.runCommand(command);
////            Document documentResult = database.runCommand(new Document("drop", script));
//            System.out.println(documentResult);
////            database.runCommand()
//            Document document = new Document("name", "user1");
//            BsonDocument document1 = new BsonDocument();
//            FindIterable<Document> documents = collection.find(document);
//
//            // 遍历查询结果
//            try (MongoCursor<Document> cursor = documents.iterator()) {
//                while (cursor.hasNext()) {
//                    Document result = cursor.next();
//                    System.out.println(result);
////                    result.add(document.toJson());
//                }
//            }
////            // 选择集合
////            MongoCollection<Document> collection = database.getCollection(this.collectionName);
////
////            // 构建查询条件
////            Document query = Document.parse(value);
////            // 执行查询
////            FindIterable<Document> documents = collection.find(query);
////
////            // 遍历查询结果
////            try (MongoCursor<Document> cursor = documents.iterator()) {
////                while (cursor.hasNext()) {
////                    Document document = cursor.next();
////                    result.add(document.toJson());
////                }
////            }
//        }
//        // 获取数据库和集合
////        DBCollection dbCollection = mongoClient.getDB("test").getCollection("cl");
//////        JacksonDBCollection<PersonDO, String> jackCollection = JacksonDBCollection.wrap(
//////                dbCollection,
//////                MyEntity.class,
//////                String.class,
//////                new ObjectMapper()
//////        );
////
////        // 执行原生查询
////        BasicDBObject query = new BasicDBObject("name", "user1");
////        DBCursor cursor = dbCollection.find(query);
////
////        // 遍历结果
////        while (cursor.hasNext()) {
////            PersonDO entity = (PersonDO) cursor.next();
////            // 处理查询结果
////            System.out.println(entity);
////        }
////
////        // 关闭连接
////        mongoClient.close();
//    }
//}
