package com.chen.service;

import com.chen.daomain.Street;

import java.util.List;

public interface SteertService {

    //通过区域编号id 查询街道；
    List<Street> queryStreetByDid(Integer did);
}
