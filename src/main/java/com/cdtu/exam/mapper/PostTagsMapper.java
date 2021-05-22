package com.cdtu.exam.mapper;

import com.cdtu.exam.entity.PostTags;
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
@Mapper
@Component
public interface PostTagsMapper extends BaseMapper<PostTags> {

}
