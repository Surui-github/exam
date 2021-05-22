package com.cdtu.exam.mapper;

import com.cdtu.exam.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author SuRui
 * @since 2021-04-26
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * @author SuRui
     * @name queryUserByName
     * @param name 名称
     * @return User
     */
    public User queryUserByName(String name);

}
