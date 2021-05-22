package com.cdtu.exam.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cdtu.exam.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : SuRui
 * @ClassName : indexController
 * @Description : TODO
 * @date : 2021/4/27 16:12
 **/
//@Deprecated
@RestController
public class IndexController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public Integer index(HttpServletResponse response,HttpServletRequest request){
        Integer status = response.getStatus();
        return status;
    }

    @RequestMapping("/denglu")
    public Integer denglu(HttpServletResponse response, @Param("username") String username, @Param("password") String password){
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        //Cookie cookie = new Cookie("username", username);
        //Cookie cookie = new Cookie("password", password);
        //response.addCookie(cookie);

        Integer status = userService.dengLu(username,password);
        System.out.println("status:" + status);
        return status;
    }


}
