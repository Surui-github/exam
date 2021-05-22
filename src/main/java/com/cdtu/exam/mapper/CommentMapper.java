package com.cdtu.exam.mapper;

import com.cdtu.exam.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author SuRui
 * @since 2021-04-26
 */
@Component
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

}
