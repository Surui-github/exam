package com.cdtu.exam.controller;


import com.cdtu.exam.entity.Feedback;
import com.cdtu.exam.entity.Notice;
import com.cdtu.exam.service.FeedbackService;
import com.cdtu.exam.service.NoticeService;
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
 * @since 2021-04-28
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;
    @RequestMapping("/list")
    public DataVO<Notice> list(@Param("page") Integer page, @Param("limit") Integer limit, @Param("username") String username, @Param("title") String title){
        return noticeService.findData(page,limit,username,title);
    }

}

