package com.chen.controller;

import com.chen.daomain.Users;
import com.chen.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller("usersController")
@RequestMapping("/page/")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping("selectUsersExits")
    public Map<String, Object> selectUsersExits(String name){
       Map<String,Object> map =new HashMap<>();

        boolean b = usersService.UsersExist(name);

        if(b){
            map.put("exits",true);
            return map;
        }else {
            map.put("exits",false);
            return map;
        }
    }

    //实现登入操作；
     @RequestMapping("login")
    public String login(String name, String password, HttpSession session){
        Map<String,Object> map =new HashMap<>();

         Users users = usersService.queryLogin(name, password);

         if(users==null){
             return "redirect:login.jsp";
         }else {

            session.setAttribute("usersInfo",users);

            session.setMaxInactiveInterval(10*60);
            return "redirect:selectHouseAll";

         }
    }

}
