//package cn.bestsec.vulweb.test;
//
//import cn.bestsec.vulweb.entity.BookDO;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//
//public class HibernateTests {
//    public static void main(String[] args) {
//        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
//        SessionFactory sessionFactory = configuration.buildSessionFactory();
//        Session newSession = sessionFactory.openSession();
//        Transaction newTransaction = newSession.beginTransaction();
////        newSession
////        BookDO retrievedBook = newSession.load(BookDO.class, 1);
////        System.out.println("Retrieved Student: " + retrievedBook);
//        newTransaction.commit();
//        newSession.close();
////
////        // Step 5: Close the session factory
////        sessionFactory.close();
//    }
//}
