package com.cdtu.exam.mapper;

import com.cdtu.exam.entity.Notice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author SuRui
 * @since 2021-04-28
 */
@Mapper
@Repository
public interface NoticeMapper extends BaseMapper<Notice> {

}
