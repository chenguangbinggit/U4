package com.chen.service;

import com.chen.daomain.Users;

public interface UsersService {
    //判断用户名是否存在
    boolean UsersExist(String name);

    //实现登入
    Users  queryLogin(String name,String password);
}
