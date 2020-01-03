package com.chen.service.impl;

import com.chen.daomain.District;
import com.chen.daomain.DistrictExample;
import com.chen.mapper.DistrictMapper;
import com.chen.pageUtil.Condition;
import com.chen.pageUtil.PageUtil;
import com.chen.service.DistriceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DistriceServiceImpl implements DistriceService {

    @Autowired
    private DistrictMapper districtMapper;

    //分页查询；
    @Override
    public PageInfo<District> queryLimitDistrict(Condition condition) {

        PageHelper.startPage(condition.getPage(),condition.getRows());

        DistrictExample districtExample =new DistrictExample();

        if(condition.getId()!=null){
            districtExample.createCriteria().andIdEqualTo(condition.getId());
        }
        if(condition.getName()!=null){
            districtExample.createCriteria().andNameLike("%"+condition.getName()+"%");
        }

        List<District> districtList = districtMapper.selectByExample(districtExample);


        return new PageInfo<>(districtList);
    }


    /**
     * 添加District
     * @param district
     * @return
     */
    @Override
    public int addDistrict(District district) {


        return districtMapper.insertSelective(district);
    }

    @Override
    public int updateDistrict(District district) {

        return districtMapper.updateByPrimaryKeySelective(district);
    }

    @Override
    public District queryByDistrict(Integer id) {
        return districtMapper.selectByPrimaryKey(id);
    }

    @Override
    public int delDistrict(Integer id) {

        return districtMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteDistrictAll(Integer[] id) {
        return districtMapper.deleteByDistrictAll(id);
    }

    @Override
    public List<District> queryDistrict() {
        DistrictExample districtExample =new DistrictExample();
        List<District> districtList = districtMapper.selectByExample(districtExample);

        return districtList ;
    }
}
