package com.cdtu.exam.service;

import com.cdtu.exam.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cdtu.exam.vo.PostVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author SuRui
 * @since 2021-04-26
 */
public interface CommentService extends IService<Comment> {

    /**
     * 启示详情
     * @param id :postID
     * @return
     */
    public List<Comment> details(@Param("id") String id);

}
