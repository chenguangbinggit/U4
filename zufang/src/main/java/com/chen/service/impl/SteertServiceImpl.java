package com.chen.service.impl;

import com.chen.daomain.Street;
import com.chen.daomain.StreetExample;
import com.chen.mapper.StreetMapper;
import com.chen.service.SteertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SteertServiceImpl implements SteertService {


    @Autowired
    private StreetMapper streetMapper;


    @Override
    public List<Street> queryStreetByDid(Integer did) {


        StreetExample streetExample =new StreetExample();

        StreetExample.Criteria criteria = streetExample.createCriteria();

        criteria.andDistrictIdEqualTo(did);

        List<Street> streetList = streetMapper.selectByExample(streetExample);


        return streetList;
    }
}
