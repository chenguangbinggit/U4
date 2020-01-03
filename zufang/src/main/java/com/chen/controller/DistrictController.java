package com.chen.controller;


import com.chen.daomain.District;
import com.chen.pageUtil.Condition;
import com.chen.pageUtil.PageUtil;
import com.chen.service.DistriceService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//@Controller
@RestController
@RequestMapping("/static/")
public class DistrictController {


    @Autowired
    private DistriceService districeService;

    //分页查询；
//    @ResponseBody
    @RequestMapping("selectLimitDistrice")
    public Map<String,Object> selectLimitDistrice( Condition condition){

        System.out.println("地址： "+condition.getName()+"编号："+condition.getId());
        PageInfo<District> districtPageInfo = districeService.queryLimitDistrict(condition);
        Map<String,Object> map =new HashMap<>();
        map.put("total",districtPageInfo.getTotal());
        map.put("rows",districtPageInfo.getList());

        return map;
    }

    /**
     *添加
     * @param district
     * @return
     */
    @RequestMapping("PutDistrice")
    public Map<String,Object> PutDistrice(District district ) {

        Map<String, Object> map = new HashMap<>();
        try {
            int result = districeService.addDistrict(district);



            map.put("result", result);
            return map;
        } catch (Exception e) {
            map.put("result",-1);
            return map;
        }

    }

//    修改方法
    @RequestMapping("UpdateDistrice")
    public Map<String,Object> UpdateDistrice(District district ) {

        Map<String, Object> map = new HashMap<>();
        try {
            int result = districeService.updateDistrict(district);



            map.put("result", result);
            return map;
        } catch (Exception e) {
            map.put("result",-1);
            return map;
        }

    }

    //通过Id查询对象；
    @RequestMapping("selectDistrice")
    public District selectDistrice(Integer id ) {


        try {
            District district = districeService.queryByDistrict(id);



            return district;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    //通过Id删除对象；
    @RequestMapping("delDistrice")
    public Map<String,Object> delDistrice(Integer id ) {

        Map<String ,Object> map=new HashMap<>();
        try {
            int delInfo = districeService.delDistrict(id);


            map.put("delInfo",delInfo);
            return map;
        } catch (Exception e) {
           map.put("delInfo",0);
            return map;
        }

    }


    //通过Id批量删除对象；
    @RequestMapping("delDistriceAll")
    public Map<String,Object> delDistriceAll(String ids) {
        Map<String ,Object> map=new HashMap<>();
        try {


            String[] idgSplit = ids.split(",");

            Integer [] id=new Integer[idgSplit.length];

            for (int i = 0; i <idgSplit.length ; i++) {
                id[i]=new Integer(idgSplit[i]);
            }
            int delInfo = districeService.deleteDistrictAll(id);


            map.put("delInfo",delInfo);
            return map;
        } catch (Exception e) {
            map.put("delInfo",0);
            return map;
        }

    }
}
