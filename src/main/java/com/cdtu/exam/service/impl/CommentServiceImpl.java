package com.cdtu.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cdtu.exam.entity.Comment;
import com.cdtu.exam.mapper.CommentMapper;
import com.cdtu.exam.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdtu.exam.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author SuRui
 * @since 2021-04-26
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> details(String id) {

        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("post_id", id);
        return commentMapper.selectList(wrapper);
    }
}
