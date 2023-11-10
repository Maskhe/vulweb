package cn.bestsec.vulweb.dao;

import cn.bestsec.vulweb.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    User queryUserByName(String name);
    User queryUserByNameVul(String name);
    @Select("select * from user where name='${name}'")
    User queryUserByNameVul2(String name);
}
