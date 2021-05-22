package com.cdtu.exam.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdtu.exam.entity.Post;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cdtu.exam.vo.PostVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author SuRui
 * @since 2021-04-30
 */
@Mapper
@Repository
public interface PostMapper extends BaseMapper<Post> {
    /**
     * 根据条件查询告示
     * @param tagsId :标签ID
     * @param page :页码
     * @param limit :每页行数
     * @return List<Post>
     */
    List<Post> list(@Param("page") Integer page, @Param("limit") Integer limit, @Param("tagsId") String tagsId);
}
