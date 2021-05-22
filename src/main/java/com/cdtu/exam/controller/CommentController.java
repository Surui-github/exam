package com.cdtu.exam.controller;


import com.cdtu.exam.entity.Comment;
import com.cdtu.exam.service.CommentService;
import com.cdtu.exam.vo.PostVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/details")
    public List<Comment> details(@Param("id") String id){
        System.out.println("id:" + id);
        return commentService.details(id);
    }

}

