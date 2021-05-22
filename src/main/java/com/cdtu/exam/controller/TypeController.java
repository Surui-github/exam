package com.cdtu.exam.controller;


import com.alibaba.fastjson.JSONObject;
import com.cdtu.exam.entity.Type;
import com.cdtu.exam.service.TypeService;
import com.cdtu.exam.vo.DataVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
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
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    /**
     * 查询所有标签
     * @return
     */
    @RequestMapping("/list")
    public DataVO<Type> list(@Param("Page") Integer page, @Param("limit") Integer limit,@Param("name") String name, @Param("typeWeb") String typeWeb){
        System.out.println("name:"+name);
        System.out.println("typeWeb:"+typeWeb);
        return typeService.findDate(page,limit,name,typeWeb);
    }

    @RequestMapping("/save")
    public JSONObject save(String ids){
        JSONObject json = new JSONObject();
        try {
            System.out.println(ids);
            typeService.save(ids);
            json.put("status", "succ");
        } catch (Exception e) {
            json.put("status", "fail");
            e.printStackTrace();
        }
        return json;
    }

    @RequestMapping("/deleteByIds")
    public JSONObject deleteByIds(String ids){
        JSONObject json = new JSONObject();
        try {
            System.out.println(ids);
            typeService.deleteByIds(ids);
            json.put("status", "succ");
        } catch (Exception e) {
            json.put("status", "fail");
            e.printStackTrace();
        }
        return json;
    }

    @RequestMapping("/edit")
    public JSONObject editUser(String ids){
        JSONObject json = new JSONObject();
        try {
            System.out.println(ids);
            typeService.edit(ids);
            json.put("status", "succ");
        } catch (Exception e) {
            json.put("status", "fail");
            e.printStackTrace();
        }
        return json;
    }

}

