package cn.bestsec.vulweb.service.impl;

import cn.bestsec.vulweb.entity.BookDO;
import cn.bestsec.vulweb.service.HQLInjectionService;
import org.apache.hc.client5.http.auth.AuthStateCacheable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import javax.persistence.Query;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

/**
 * @author hjx
 * @since 2024/1/16
 */
@Service
public class HQLInjectionServiceImpl implements HQLInjectionService {

    private final EntityManagerFactory entityManagerFactory;
    public HQLInjectionServiceImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }


    @Override
    public String createQuery(String p) {
        try ( Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("from BookDO book where book.authorName='" + p + "'");
            List<BookDO> books = query.getResultList();
            transaction.commit();
            session.close();
            return books.toString();
        }
    }
}
