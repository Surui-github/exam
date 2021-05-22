package com.cdtu.exam.service.impl;

import com.cdtu.exam.service.PostService;
import com.cdtu.exam.vo.PostVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.ws.Service;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceImplTest {

    @Autowired
    private PostService postService;

    @Test
    public void test(){
        PostVO postVO = postService.details("1258");
        System.out.println(postVO.getUsername());
    }

}