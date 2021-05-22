package com.cdtu.exam.controller;


import com.alibaba.fastjson.JSONObject;
import com.cdtu.exam.entity.Tag;
import com.cdtu.exam.service.TagService;
import com.cdtu.exam.vo.DataVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;
    @RequestMapping("/list")
    public DataVO<Tag> list(@Param("page") Integer page, @Param("limit") Integer limit, @Param("name") String name, @Param("tagWeb") String tagWeb){
        System.out.println(tagWeb);
        System.out.println(page);
        System.out.println(limit);
        return tagService.findData(page,limit,name,tagWeb);
    }

    @RequestMapping("/save")
    public JSONObject save(String ids){
        JSONObject json = new JSONObject();
        try {
            System.out.println(ids);
            tagService.save(ids);
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
            tagService.deleteByIds(ids);
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
            tagService.edit(ids);
            json.put("status", "succ");
        } catch (Exception e) {
            json.put("status", "fail");
            e.printStackTrace();
        }
        return json;
    }

}

