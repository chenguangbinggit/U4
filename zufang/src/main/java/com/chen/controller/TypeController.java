package com.chen.controller;

import com.chen.daomain.Type;
import com.chen.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller("typeCOntroller")
@RequestMapping("/page/")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @RequestMapping("selectTypeAll")
    @ResponseBody
    public List<Type> selectTypeAll(){
     return    typeService.queryType();
    }
}
