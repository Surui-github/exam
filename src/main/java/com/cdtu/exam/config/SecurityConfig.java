package com.cdtu.exam.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author : SuRui
 * @ClassName : WebSecurityConfigurerAdapter
 * @Description : Security配置
 * @date : 2021/3/18 10:52
 **/
@Deprecated
//@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.csrf().ignoringAntMatchers("/druid/*");

        http.authorizeRequests()
            //设置权限
            //首页和登录页允许全部
            .antMatchers("/").permitAll()
            .anyRequest().authenticated()          //表示剩余的其他接口，登录之后就能访问
            .and()
            .formLogin()
            //设置登录页（注意自定义的登录页需要放开全部访问的权限）
            .loginPage("/")

            .and()
            //禁用 csrf,防止跨站攻击
            .csrf().disable();
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(password());

    }

    @Bean
    PasswordEncoder password(){
        return new BCryptPasswordEncoder();
    }
}
