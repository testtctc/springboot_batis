package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserDao {
    //插入数据
    int insert(User record);
    //查询用户
    List<User> selectUsers();
}
