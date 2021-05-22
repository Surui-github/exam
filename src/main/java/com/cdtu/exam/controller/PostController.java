package com.cdtu.exam.controller;


import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdtu.exam.entity.Post;
import com.cdtu.exam.entity.User;
import com.cdtu.exam.service.PostService;
import com.cdtu.exam.service.UserService;
import com.cdtu.exam.vo.DataVO;
import com.cdtu.exam.vo.PostVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author SuRui
 * @since 2021-04-26
 */
@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;
    @RequestMapping("/list")
    public DataVO<Post> list(@Param("page") Integer page, @Param("limit") Integer limit, @Param("flag") String flag, @Param("typeId") String typeId){

        System.out.println(page);
        System.out.println(limit);
        return postService.findData(page, limit, flag, typeId);
    }

    @RequestMapping("/listVO")
    public DataVO<PostVO> listVO(@Param("Page") Integer page, @Param("limit") Integer limit, @Param("tagsId") String tagsId, @Param("typeId") String typeId, @Param("columnValue") String columnValue){
        System.out.println(page);
        System.out.println(limit);
        System.out.println("tagsId:" + tagsId);
        System.out.println("typeId:" + typeId);
        System.out.println("columnValue:" + columnValue);
        return postService.findDataVO(page,limit,tagsId,typeId,columnValue);
    }


    @RequestMapping("/details")
    public PostVO details(@Param("id") String id){
        System.out.println(id);
        return postService.details(id);
    }

    @RequestMapping("/selectByUsername")
    public List<PostVO> selectByUsername(@Param("username") String username){
        return postService.selectByUsername(username);
    }

    @RequestMapping("/save")
    public JSONObject save(@Param("ids") String ids, @Param("username") String username, @Param("createTime") String createTime){
        JSONObject json = new JSONObject();
        try {
            System.out.println(ids);
            System.out.println(username);
            System.out.println(createTime);
            //当前时间
            Date date = DateUtil.date();
            System.out.println(date);
            postService.save(ids,username,createTime);
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
            postService.deleteByIds(ids);
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
            postService.edit(ids);
            json.put("status", "succ");
        } catch (Exception e) {
            json.put("status", "fail");
            e.printStackTrace();
        }
        return json;
    }

}

