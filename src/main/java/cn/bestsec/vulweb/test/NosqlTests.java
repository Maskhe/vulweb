//package cn.bestsec.vulweb.test;
//
//import com.mongodb.BasicDBObject;
//import com.mongodb.DBCollection;
//import org.mongodb.morphia.Datastore;
//import org.mongodb.morphia.Morphia;
//import org.mongodb.morphia.query.Query;
//import org.springframework.data.mongodb.core.MongoTemplate;
//
//public class NosqlTests {
//    public static void main(String[] args) {
//        MongoTemplate mongoTemplate;
//        Morphia morphia = new Morphia();
//        Datastore datastore = morphia.createDatastore(/*MongoClient or DB*/, "your_database_name");
//
//        // 获取 MongoDB 原生 DBCollection
//        DBCollection dbCollection = datastore.getDB().getCollection("your_collection_name");
//
//        // 执行原生查询
//        BasicDBObject query = new BasicDBObject("fieldName", "fieldValue");
//        Query<?> morphiaQuery = datastore.createQuery("your_collection_name").disableValidation();
//        morphiaQuery.or(query); // 通过 Morphia 进行查询条件的设置
//
//        // 获取结果
//        List<?> results = morphiaQuery.asList();
//        for (Object result : results) {
//            // 处理查询结果
//            System.out.println(result);
//        }
//    }
//}
