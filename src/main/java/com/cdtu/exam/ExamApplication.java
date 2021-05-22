package com.cdtu.exam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.security.Security;

/**
 * @author Administrator
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@MapperScan("com.cdtu.exam.mapper")
public class ExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamApplication.class, args);
    }

}
