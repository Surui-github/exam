package com.cdtu.exam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author SuRui
 */
@Deprecated
//@Configuration
//@EnableWebSecurity
public class MySecurity extends WebSecurityConfigurerAdapter {

    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.authorizeRequests()
                //设置权限
                //首页和登录页允许全部
                .antMatchers("/","/toLogin").permitAll()
                //有权限才可以访问
                .antMatchers("/user/add").hasAnyAuthority("user:add")
                .antMatchers("/user/update").hasAnyAuthority("user:update")
                .anyRequest().authenticated()          //表示剩余的其他接口，登录之后就能访问
                .and()
                .formLogin()
                //设置登录页（注意自定义的登录页需要放开全部访问的权限）
                .loginPage("/toLogin")
                //设置登录的参数
                .usernameParameter("username")
                .passwordParameter("password")
                //设置登录成功跳转页
                .loginProcessingUrl("/login")
                .and()
                //设置退出
                .logout().deleteCookies("remove").invalidateHttpSession(true)
                //设置退出成功跳转页
                .logoutSuccessUrl("/")
                .and()
                //禁用 csrf,防止跨站攻击
                .csrf().disable();
    }

    @Bean
    public PasswordEncoder createPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}

