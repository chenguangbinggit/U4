package com.chen.pcontroller;

import com.chen.daomain.Street;
import com.chen.service.SteertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/page/")
@Controller("steetController")
public class SteetController {


    @Autowired
    private SteertService steertService;

    @RequestMapping("selectByStreet")
    @ResponseBody
    public List<Street>  selectByStreet(Integer did){
        return steertService.queryStreetByDid(did);
    }
}
