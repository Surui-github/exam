package com.cdtu.exam.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cdtu.exam.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import sun.security.util.Password;

import java.util.List;

/**
 * @author : SuRui
 * @ClassName : MyUserDetailsService
 * @Description : TODO
 * @date : 2021/4/27 10:47
 **/
@Deprecated
//@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //调用userMapper方法，根据用户名查询数据库
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username",username);
        com.cdtu.exam.entity.User user = userMapper.selectOne(wrapper);
        //判断
        if( username == null ){
            throw new UsernameNotFoundException("用户不存在");
        }
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("role");
        //查询数据库，得到用户名和密码，返回
        return new User(user.getUsername(),
                new BCryptPasswordEncoder().encode(user.getPassword()),auths);
    }
}
