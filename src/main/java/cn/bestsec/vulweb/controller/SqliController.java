package cn.bestsec.vulweb.controller;

import cn.bestsec.vulweb.dao.BookDao;
import cn.bestsec.vulweb.entity.User;
import cn.bestsec.vulweb.entity.Book;
import cn.bestsec.vulweb.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/sqli")
public class SqliController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BookDao bookDao;

    @PersistenceContext
    private EntityManager entityManager;
    private Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

    public SqliController() throws SQLException {
    }

    @RequestMapping("/level1")
    public String level1(@RequestParam  String p){
        /*
          报错注入, JdbcTemplate.execute()
         */
        String sql = "select name from user where name='" + p + "'";
        try{
            jdbcTemplate.execute(sql);
        }catch(Exception e){
            return e.getMessage();
        }

        return "语句执行成功！！";
    }

    @RequestMapping("/level2")
    public List<?> level2(@RequestParam String p){
        /*
        报错注入，JdbcTemplate.query()
         */
        String sql = "select * from user where name='" + p + "'";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    @RequestMapping("/level3")
    public String level3(@RequestParam String p){
        String sql = "insert into user values('user2', '" + p + "')" ;
        int row = jdbcTemplate.update(sql);
        return "本次修改共影响" + row + "行";
    }

    @RequestMapping("/level4")
    public List<?> level4(@RequestParam String p){
        String sql = "select * from user where name='" + p + "'";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }

    @RequestMapping("/level5")
    public String level5(@RequestParam String p){
        String sql = "select * from user where name='" + p + "'";
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return sql;
    }

    @RequestMapping("/level6")
    public String level6(@RequestParam String p){
        String sql = "select * from user where name='" + p + "'";
        Statement stmt;
        try{
            stmt = conn.createStatement();
            stmt.executeQuery(sql);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return sql;
    }

    @RequestMapping("level7")
    public String level7(@RequestParam String p){
        String sql = "select * from user where name='" + p + "'";
        try{
            Statement stmt = conn.createStatement();
            System.out.println(stmt.execute(sql, new int[]{0,1}));
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return sql;
    }

    @RequestMapping("/level8")
    public String level8(@RequestParam String p){
        String sql = "select * from user where name='" + p + "'";
        try{
            Statement stmt = conn.createStatement();
            System.out.println(stmt.execute(sql,new String[]{"name", "password"}));
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return sql;
    }

    @RequestMapping("/level9")
    public String level9(@RequestParam String p){
        String sql = "select * from user where name='" + p + "'";
        try{
            Statement stmt = conn.createStatement();
            System.out.println(stmt.execute(sql, Statement.NO_GENERATED_KEYS));
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return "level9:" + sql;
    }

    @RequestMapping("/level10")
    public String level10(@RequestParam String p){
        String sql = "insert into user(name) values('" + p + "')";
        String sql2 = "insert into  user(password) values('" + p + "')";
        try{
            Statement stmt = conn.createStatement();
            stmt.addBatch(sql);
            stmt.addBatch(sql2);
            System.out.println(Arrays.toString(stmt.executeBatch()));
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return "level9:" + sql;
    }

    @RequestMapping("/level11")
    public String level11(@RequestParam String p){
        String sql = "select name, password from user where name=? and password='" + p + "'";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, p);
            stmt.execute();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return sql;
    }

    @RequestMapping("/level12")

    public String level12(@RequestParam String p){
        /*
        mybatis无漏洞写法
        */
        User user = userMapper.queryUserByName(p);
        if(user != null){
            return user.toString();
        }
        return "用户找不到";
    }

    @RequestMapping("/level13")
    public String level13(String p){
        /*
        mybatis存在漏洞写法
         */
        User user = userMapper.queryUserByNameVul(p);
        if(user != null){
            return user.toString();
        }
        return "用户找不到";
    }

    @RequestMapping("/level14")
    public String level14(String p){
        /*
        mybatis存在漏洞
         */
        User user = userMapper.queryUserByNameVul2(p);
        if(user != null){
            return user.toString();
        }
        return "用户找不到";
    }

    @RequestMapping("/level15")
    public String level15(int p){
        /*
        spring data jpa不存在漏洞
         */
        Optional<Book> book = bookDao.findById(p);
        return book.toString();
    }

    @RequestMapping("/level16")
    public String level16(String p){
        /*
        spring data jpa不存在漏洞
         */
        Book book = bookDao.getBookByBookName(p);
        if(book != null){
            return book.toString();
        }
        return "书籍未找到";
    }

    @RequestMapping("/level17")
    public String level17(String p){
        /*
        spring data jpa无漏洞
         */
        Book book = bookDao.getBookByName2(p);
        if (book != null){
            return book.toString();
        }
        return "书籍找不到";
    }

    @RequestMapping("/level18")
    public String level18(String p) {
        /*
        spring data jpa存在漏洞
         */
        String sql = "select b from Book b where b.authorName='" + p + "'";
        System.out.println(sql);
        Query query = entityManager.createQuery(sql);
        Book book;
        try {
            book = (Book) query.getSingleResult();
        } catch (Exception e) {
            return e.getMessage();
        }

        return book.toString();

    }
}
