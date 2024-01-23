package cn.bestsec.vulweb.service.impl;


import cn.bestsec.vulweb.dao.BookDao;
import cn.bestsec.vulweb.entity.BookDO;
import cn.bestsec.vulweb.entity.User;
import cn.bestsec.vulweb.dao.UserDao;
import cn.bestsec.vulweb.service.SqliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SqliServiceImpl implements SqliService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserDao userDao;

    @Autowired
    private BookDao bookDao;

    @PersistenceContext
    private EntityManager entityManager;
    private final Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");

    public SqliServiceImpl() throws SQLException {
    }

    @Override
    public String level1(String p){
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

    @Override
    public List<?> level2(String p){
        /*
        报错注入，JdbcTemplate.query()
         */
        String sql = "select * from user where name='" + p + "'";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public String level3(String p){
        String sql = "insert into user values('user2', '" + p + "')" ;
        int row = jdbcTemplate.update(sql);
        return "本次修改共影响" + row + "行";
    }

    @Override
    public List<?> level4(String p){
        String sql = "select * from user where name='" + p + "'";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }

    @Override
    public String level5(String p){
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

    @Override
    public String level6(String p){
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

    @Override
    public String level7(String p){
        String sql = "select * from user where name='" + p + "'";
        try{
            Statement stmt = conn.createStatement();
            System.out.println(stmt.execute(sql, new int[]{0,1}));
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return sql;
    }

    @Override
    public String level8(String p){
        String sql = "select * from user where name='" + p + "'";
        try{
            Statement stmt = conn.createStatement();
            System.out.println(stmt.execute(sql,new String[]{"name", "password"}));
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return sql;
    }

    @Override
    public String level9(String p){
        String sql = "select * from user where name='" + p + "'";
        try{
            Statement stmt = conn.createStatement();
            System.out.println(stmt.execute(sql, Statement.NO_GENERATED_KEYS));
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return "level9:" + sql;
    }

    @Override
    public String level10(String p){
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
        return "level10:" + sql;
    }

    @Override
    public String level11(String p){
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

    @Override
    public String level12(String p){
        /*
        mybatis无漏洞写法
        */
        User user = userDao.queryUserByName(p);
        if(user != null){
            return user.toString();
        }
        return "用户找不到";
    }

    @Override
    public String level13(String p){
        /*
        mybatis存在漏洞写法
         */
        User user = userDao.queryUserByNameVul(p);
        if(user != null){
            return user.toString();
        }
        return "用户找不到";
    }

    @Override
    public String level14(String p){
        /*
        mybatis存在漏洞
         */
        User user = userDao.queryUserByNameVul2(p);
        if(user != null){
            return user.toString();
        }
        return "用户找不到";
    }

    @Override
    public String level15(int p){
        /*
        spring data jpa不存在漏洞
         */
        Optional<BookDO> book = bookDao.findById(p);
        return book.toString();
    }

    @Override
    public String level16(String p){
        /*
        spring data jpa不存在漏洞
         */
        BookDO book = bookDao.getBookByBookName(p);
        if(book != null){
            return book.toString();
        }
        return "书籍未找到";
    }

    @Override
    public String level17(String p){
        /*
        spring data jpa无漏洞
         */
        BookDO book = bookDao.getBookByName2(p);
        if (book != null){
            return book.toString();
        }
        return "书籍找不到";
    }

    @Override
    public String level18(String p) {
        /*
        spring data jpa存在漏洞
         */
        String sql = "select b from BookDO b where b.authorName='" + p + "'";
        Query query = entityManager.createQuery(sql);
        BookDO book;
        try {
            book = (BookDO) query.getSingleResult();
        } catch (Exception e) {
            return e.getMessage();
        }

        return book.toString();
    }

    @Override
    public String level19(String p) {
        String sql = "select * from books where author_name = '" + p + "'";
        Query query = entityManager.createNativeQuery(sql);
        BookDO book;
        try {
            book = (BookDO) query.getSingleResult();
        } catch (Exception e) {
            return e.getMessage();
        }
        return book.toString();
    }
}
