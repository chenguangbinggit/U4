package com.chen.service.impl;

import com.chen.daomain.Type;
import com.chen.daomain.TypeExample;
import com.chen.mapper.TypeMapper;
import com.chen.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;
    @Override
    public List<Type> queryType() {

        TypeExample typeExample=new TypeExample();

        List<Type> typeList = typeMapper.selectByExample(typeExample);
        return typeList;
    }
}
