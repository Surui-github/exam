package com.cdtu.exam.service.impl;

import com.cdtu.exam.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;
    @Test
    public void test(){
        //System.out.println(userService.dengLu("admin","123456"));
        System.out.println(userService.findByUsername("admin"));
    }
}