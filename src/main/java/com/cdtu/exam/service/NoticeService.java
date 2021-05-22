package com.cdtu.exam.service;

import com.cdtu.exam.entity.Feedback;
import com.cdtu.exam.entity.Notice;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cdtu.exam.vo.DataVO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author SuRui
 * @since 2021-04-28
 */
public interface NoticeService extends IService<Notice> {

    /**
     * 查询失物管理信息接口
     * @return
     */
    public DataVO<Notice> findData(@Param("page") Integer page, @Param("limit") Integer limit, @Param("username") String username, @Param("title") String title);
}
