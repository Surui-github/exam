package com.cdtu.exam.service.impl;

import com.cdtu.exam.entity.Feedback;
import com.cdtu.exam.entity.Type;
import com.cdtu.exam.mapper.FeedbackMapper;
import com.cdtu.exam.service.FeedbackService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdtu.exam.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author SuRui
 * @since 2021-04-27
 */
@Service
public class FeedbackServiceImpl extends ServiceImpl<FeedbackMapper, Feedback> implements FeedbackService {

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public DataVO<Feedback> findData() {
        DataVO dataVO = new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");
        dataVO.setCount(feedbackMapper.selectCount(null));

        List<Feedback> feedbackList = feedbackMapper.selectList(null);

        dataVO.setData(feedbackList);

        return dataVO;
    }
}
