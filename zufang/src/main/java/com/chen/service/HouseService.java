package com.chen.service;

import com.chen.daomain.House;
import com.chen.pageUtil.PageUtil;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface HouseService {

    //添加房租信息；
    int addHouse(House house);

    //查看出租房信息；
    PageInfo<House> findHouseAll(Integer did, PageUtil pageUtil);

    //查询信息回显
    House findHouse(String id);

}
