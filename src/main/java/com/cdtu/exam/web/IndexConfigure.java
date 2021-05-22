package com.cdtu.exam.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : SuRui
 * @ClassName : indexConfigure
 * @Description : TODO
 * @date : 2021/4/26 11:23
 **/

@RestController
public class IndexConfigure {

    @RequestMapping("/login")
    public Integer indexPage(HttpServletRequest request, HttpServletResponse responseStatus){
        StringBuffer requestURL = request.getRequestURL();
        Integer status = responseStatus.getStatus();
        return status;

    }


}
