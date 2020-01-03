package com.chen.pcontroller;

import com.chen.daomain.District;
import com.chen.daomain.Type;
import com.chen.service.DistriceService;
import com.chen.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("DistrictController")
@RequestMapping("/page/")
public class DistrictController {

    @Autowired
    private DistriceService districeService;

    @RequestMapping("selectDistriceAll")
    @ResponseBody
    public List<District> selectDistriceAll(){
        return    districeService.queryDistrict();
    }
}
