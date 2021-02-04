package com.example.demo.service;

import com.example.demo.entity.User;
import com.github.pagehelper.PageInfo;

public interface UserService {
    int addUser(User user);

    PageInfo<User> findAllUser(int pageNum, int pageSize);
}
