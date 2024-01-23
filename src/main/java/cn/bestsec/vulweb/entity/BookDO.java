package cn.bestsec.vulweb.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="books")
public class BookDO {
    @Column(name = "book_name")
    private String bookName;
    @Column(name = "author_name")
    private String authorName;
    private float price;
    @Id
    private Integer id;

}
