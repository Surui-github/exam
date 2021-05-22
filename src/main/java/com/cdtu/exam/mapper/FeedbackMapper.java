package com.cdtu.exam.mapper;

import com.cdtu.exam.entity.Feedback;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author SuRui
 * @since 2021-04-27
 */
@Mapper
@Repository
public interface FeedbackMapper extends BaseMapper<Feedback> {

}
