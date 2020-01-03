package com.chen.pcontroller;


import com.chen.daomain.House;
import com.chen.daomain.Users;
import com.chen.pageUtil.PageUtil;
import com.chen.service.HouseService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller("houseController")
@RequestMapping("/page/")
public class HouseController {

    @Autowired
    private HouseService houseService;


    @RequestMapping("addHouseInfo")
    public String addHouseInfo(HttpSession session, House house, @RequestParam(value = "pfile",required = false) CommonsMultipartFile pfile){


        try { //实现文件上传

        //获取文件上传名称；
        String filename = pfile.getOriginalFilename();
        //取后缀名；
        String substring = filename.substring(filename.lastIndexOf("."));
        //取日期毫秒数为文件名称；
            String milli=System.currentTimeMillis()+"";

        String millis = milli+substring;

        //存放位置
        String savrPath="d:\\imgs\\"+millis;

        //读取
        File saveFile =new File(savrPath);


            pfile.transferTo(saveFile);//上传



            //将数据添加到数据库；
            //修改House 实体，添加设置；
            //设置编号；
            house.setId(milli);
            //设置所属用户；
            Users usersInfo = (Users) session.getAttribute("usersInfo");

            house.setUserId(usersInfo.getId());

            //设置图片路径；
            house.setPath(millis);

           houseService.addHouse(house);

           return "redirect:selectHouseAll";

        } catch (IOException e) {
                e.printStackTrace();
                }

                return "page/error";

    }


    @RequestMapping("selectHouseAll")
    public ModelAndView selectHouseAll(HttpSession session, PageUtil pageUtil, ModelAndView mv){
        pageUtil.setRows(5);

        //获取用户登入的ID
        Users usersInfo = (Users) session.getAttribute("usersInfo");
        Integer did = usersInfo.getId();

        PageInfo<House> houseAll = houseService.findHouseAll(did, pageUtil);

       mv.addObject("houseAll",houseAll);

       mv.setViewName("page/guanli");



        return mv;
    }


    @RequestMapping("selectHouse")
    public ModelAndView selectHouse(String id, ModelAndView mv){


        House house = houseService.findHouse(id);

        mv.addObject("house",house);
        mv.setViewName("page/upfabu");


        System.out.println(house.toString());
        return mv;
    }
}
