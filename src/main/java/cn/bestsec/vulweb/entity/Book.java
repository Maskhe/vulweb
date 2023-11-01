package cn.bestsec.vulweb.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="books")
public class Book {
    private String bookName;
    private String authorName;
    private float price;
    @Id
    private Integer id;

}
