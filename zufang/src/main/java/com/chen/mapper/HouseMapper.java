package com.chen.mapper;

import com.chen.daomain.House;
import com.chen.daomain.HouseExample;
import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    //多表查询，出租房信息；
    List<House> queryHouseAll(Integer did);

    //数据回显；
    House queryHouse(String id);
}