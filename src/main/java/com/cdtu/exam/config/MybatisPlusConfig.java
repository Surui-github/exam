package com.cdtu.exam.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : SuRui
 * @ClassName : MybatisPlusConfig
 * @Description : TODO
 * @date : 2021/5/1 11:10
 **/
@Configuration
@MapperScan("com.cdtu.exam.mapper")
public class MybatisPlusConfig {


    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
