package com.cdtu.exam.controller;


import com.cdtu.exam.entity.Feedback;
import com.cdtu.exam.service.FeedbackService;
import com.cdtu.exam.vo.DataVO;
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
 * @since 2021-04-27
 */
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;
    @RequestMapping("/list")
    public DataVO<Feedback> list(){
        return feedbackService.findData();
    }

}

