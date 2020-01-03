package com.chen.service;

        import com.chen.daomain.District;
        import com.chen.pageUtil.Condition;
        import com.chen.pageUtil.PageUtil;
        import com.github.pagehelper.PageInfo;

        import java.util.List;

public interface DistriceService {

    //实现分页查询；
    public PageInfo<District> queryLimitDistrict(Condition condition);

    //添加District数据；
    int addDistrict(District district);

    //修改District数据；
    int updateDistrict(District district);

    //回显数据
    District queryByDistrict(Integer id);

    //删除数据
    int delDistrict(Integer id);

    //批量删除
    int deleteDistrictAll(Integer [] id);

    //查询区域；
    List<District> queryDistrict();
}
