package com.cdtu.exam.controller;


import com.alibaba.fastjson.JSONObject;
import com.cdtu.exam.entity.User;
import com.cdtu.exam.service.UserService;
import com.cdtu.exam.vo.DataVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author SuRui
 * @since 2021-04-26
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("/list")
    public DataVO<User> list(@Param("page") Integer page, @Param("limit") Integer limit, @Param("username") String username, @Param("type") String type){
        System.out.println(page);
        System.out.println(username);
        System.out.println(type);
        return userService.findData(page,limit,username,type);
    }

    @RequestMapping("/deleteByIds")
    public JSONObject deleteByIds(String ids){
        JSONObject json = new JSONObject();
        try {
            System.out.println(ids);
            userService.deleteByIds(ids);
            json.put("status", "succ");
        } catch (Exception e) {
            json.put("status", "fail");
            e.printStackTrace();
        }
        return json;
    }

    @RequestMapping("/edit")
    public JSONObject edit(String ids){
        JSONObject json = new JSONObject();
        try {
            System.out.println(ids);
            userService.edit(ids);
            json.put("status", "succ");
        } catch (Exception e) {
            json.put("status", "fail");
            e.printStackTrace();
        }
        return json;
    }

    @RequestMapping("/editVO")
    public JSONObject editVO(String ids){
        JSONObject json = new JSONObject();
        try {
            System.out.println(ids);
            userService.editVO(ids);
            json.put("status", "succ");
        } catch (Exception e) {
            json.put("status", "fail");
            e.printStackTrace();
        }
        return json;
    }

    @RequestMapping("/save")
    public JSONObject save(String ids){
        JSONObject json = new JSONObject();
        try {
            System.out.println(ids);
            userService.save(ids);
            json.put("status", "succ");
        } catch (Exception e) {
            json.put("status", "fail");
            e.printStackTrace();
        }
        return json;
    }

    @RequestMapping("/findByUsername")
    public User findByUsername(@Param("username") String username){
        return userService.findByUsername(username);
    }


}

