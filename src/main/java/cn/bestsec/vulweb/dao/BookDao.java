package cn.bestsec.vulweb.dao;

import cn.bestsec.vulweb.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;


@Repository
public interface BookDao extends JpaRepository<Book, Integer>, Serializable {
    @Query("select b from Book b where b.bookName = ?1")
    public Book getBookByBookName(String name);

    @Query(value = "select * from books where author_name=:name", nativeQuery = true)
    public Book getBookByName2(@Param("name") String name);
}
