package com.cdtu.exam.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdtu.exam.entity.Notice;
import com.cdtu.exam.entity.Post;
import com.cdtu.exam.entity.Tag;
import com.cdtu.exam.entity.User;
import com.cdtu.exam.mapper.UserMapper;
import com.cdtu.exam.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdtu.exam.vo.DataVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author SuRui
 * @since 2021-04-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Autowired
    private UserMapper userMapper;
    @Override
    public DataVO<User> findData(@Param("page") Integer page, @Param("limit") Integer limit, @Param("username") String username, @Param("type") String type) {
        DataVO dataVO = new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");
        dataVO.setCount(userMapper.selectCount(null));

        System.out.println(username);
        System.out.println(type);

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if(username == null && type == null){
            Page<User> page1 = new Page<>(page,limit);
            userMapper.selectPage(page1,null);
            dataVO.setData(page1.getRecords());
            return dataVO;
        }else if(username == "" && type != null){
            Page<User> page1 = new Page<>(page,limit);
            wrapper.like("type",type);
            userMapper.selectPage(page1,wrapper);
            dataVO.setData(page1.getRecords());
            return dataVO;
        }else if(username != null && type == ""){
            Page<User> page1 = new Page<>(page,limit);
            wrapper.like("username",username);
            userMapper.selectPage(page1,wrapper);
            dataVO.setData(page1.getRecords());
            return dataVO;
        }
        Map<String,Object> map = new HashMap<>(10);
        map.put("username" , username);
        map.put("type" , type);
        wrapper.allEq(map,false);
        Page<User> page1 = new Page<>(page,limit);
        userMapper.selectPage(page1,wrapper);
        dataVO.setData(page1.getRecords());
        return dataVO;
    }


    @Override
    public void deleteByIds(String ids) {
        String[] id = ids.split(",");
        for(int i=0; i < id.length; i++){
            userMapper.deleteById(id[i]);
        }
    }

    @Override
    public void edit(String ids) {
        User user = JSON.parseObject(ids,User.class);
        userMapper.updateById(user);
    }

    @Override
    public void editVO(String ids) {
        User user = JSON.parseObject(ids,User.class);
        userMapper.updateById(user);
    }

    @Override
    public void save(String ids) {
        User user = JSON.parseObject(ids,User.class);
        userMapper.insert(user);
    }

    @Override
    public Integer dengLu(String username, String password) {

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        System.out.println("password:" + password);
        if(userMapper.selectOne(wrapper) == null || userMapper.selectOne(wrapper).equals("")){
            return 405;
        }
        String password1 = userMapper.selectOne(wrapper).getPassword();
        if(password1.equals(password)){
            return 200;
        }
        return 404;


    }

    @Override
    public User findByUsername(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        return userMapper.selectOne(wrapper);
    }


}
