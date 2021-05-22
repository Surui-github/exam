package com.cdtu.exam.service;

import com.cdtu.exam.entity.Feedback;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cdtu.exam.entity.Tag;
import com.cdtu.exam.vo.DataVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author SuRui
 * @since 2021-04-27
 */
public interface FeedbackService extends IService<Feedback> {

    /**
     * 查询失物管理信息接口
     * @return
     */
    public DataVO<Feedback> findData();
}
