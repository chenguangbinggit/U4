package com.chen.service.impl;

import com.chen.daomain.Users;
import com.chen.daomain.UsersExample;
import com.chen.mapper.UsersMapper;
import com.chen.pageUtil.MD5Utils;
import com.chen.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServeceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;
    @Override
    public boolean UsersExist(String name) {
        UsersExample usersExample =new UsersExample();

        UsersExample.Criteria criteria = usersExample.createCriteria();


        criteria.andNameEqualTo(name);
        criteria.andIsadminEqualTo(new Integer("0"));


        List<Users> list = usersMapper.selectByExample(usersExample);

        if(list.size()!=0 && list!=null){
            return false;
        }else {
            return true;
        }


    }

    @Override
    public Users queryLogin(String name, String password) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria=usersExample.createCriteria();

        criteria.andPasswordEqualTo(password);
        criteria.andNameEqualTo(name);

        List<Users> users = usersMapper.selectByExample(usersExample);

        if(users.size()!=0 && users!=null){
            return users.get(0);
        }else {
            return null;
        }



    }
}
