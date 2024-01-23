package cn.bestsec.vulweb.dao;

import cn.bestsec.vulweb.entity.BookDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;


@Repository
public interface BookDao extends JpaRepository<BookDO, Integer>, Serializable {
    @Query("select b from BookDO b where b.bookName = ?1")
    BookDO getBookByBookName(String name);

    @Query(value = "select * from books where author_name=:name", nativeQuery = true)
    BookDO getBookByName2(@Param("name") String name);
}
