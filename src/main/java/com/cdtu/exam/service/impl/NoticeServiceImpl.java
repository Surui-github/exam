package com.cdtu.exam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdtu.exam.entity.Feedback;
import com.cdtu.exam.entity.Notice;
import com.cdtu.exam.entity.User;
import com.cdtu.exam.mapper.NoticeMapper;
import com.cdtu.exam.service.NoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdtu.exam.vo.DataVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author SuRui
 * @since 2021-04-28
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;
    @Override
    public DataVO<Notice> findData(@Param("page") Integer page, @Param("limit") Integer limit, @Param("username") String username, @Param("title") String title) {
        DataVO dataVO = new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");
        dataVO.setCount(noticeMapper.selectCount(null));

        System.out.println(username);
        System.out.println(title);

        QueryWrapper<Notice> wrapper = new QueryWrapper<>();
        if(username == null && title == null){
            Page<Notice> page1 = new Page<>(page,limit);
            noticeMapper.selectPage(page1,null);
            dataVO.setData(page1.getRecords());
            return dataVO;
        }else if(username == "" && title != null){
            Page<Notice> page1 = new Page<>(page,limit);
            wrapper.like("title",title);
            noticeMapper.selectPage(page1,wrapper);
            dataVO.setData(page1.getRecords());
            return dataVO;
        }else if(username != null && title == ""){
            Page<Notice> page1 = new Page<>(page,limit);
            wrapper.like("username",username);
            noticeMapper.selectPage(page1,wrapper);
            dataVO.setData(page1.getRecords());
            return dataVO;
        }
        Map<String,Object> map = new HashMap<>(10);
        map.put("username" , username);
        map.put("title" , title);
        wrapper.allEq(map,false);
        Page<Notice> page1 = new Page<>(page,limit);
        noticeMapper.selectPage(page1,wrapper);
        dataVO.setData(page1.getRecords());
        return dataVO;



    }
}
