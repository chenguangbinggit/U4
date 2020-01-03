package com.chen.service.impl;

import com.chen.daomain.House;
import com.chen.daomain.HouseExample;
import com.chen.mapper.HouseMapper;
import com.chen.pageUtil.PageUtil;
import com.chen.service.HouseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseMapper houseMapper;

    @Override
    public int addHouse(House house) {

        return houseMapper.insertSelective(house);
    }

    @Override
    public PageInfo<House> findHouseAll(Integer did, PageUtil pageUtil) {
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getRows());

        List<House> houseList = houseMapper.queryHouseAll(did);

        PageInfo<House> pageInfo =new PageInfo<>(houseList);

        return pageInfo;
    }

    @Override
    public House findHouse(String id) {
        return houseMapper.queryHouse(id);
    }
}
