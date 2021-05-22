package com.cdtu.exam.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdtu.exam.entity.Tag;
import com.cdtu.exam.entity.Type;
import com.cdtu.exam.mapper.TagMapper;
import com.cdtu.exam.service.TagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdtu.exam.vo.DataVO;
import org.apache.ibatis.annotations.Param;
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
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    @Autowired
    private TagMapper tagMapper;
    /**
     * 实现查询标签
     * @return
     */
    @Override
    public DataVO<Tag> findData(@Param("page") Integer page, @Param("limit") Integer limit, @Param("name") String name, @Param("tagWeb") String tagWeb) {
        DataVO dataVO = new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");
        dataVO.setCount(tagMapper.selectCount(null));

        if(tagWeb != null && tagWeb != ""){
            dataVO.setData(tagMapper.selectList(null));
            return dataVO;
        }
        QueryWrapper<Tag> wrapper = new QueryWrapper<>();
        wrapper.like("name",name);
        if(name == null){
            Page<Tag> page1 = new Page<>(page,limit);
            tagMapper.selectPage(page1,null);
            dataVO.setData(page1.getRecords());
            return dataVO;
        }
        Page<Tag> page1 = new Page<>(page,limit);
        tagMapper.selectPage(page1,wrapper);
        dataVO.setData(page1.getRecords());

        return dataVO;
    }

    @Override
    public void save(String ids) {
        Tag tag = JSON.parseObject(ids,Tag.class);
        tagMapper.insert(tag);
    }

    @Override
    public void deleteByIds(String ids) {
        String[] id = ids.split(",");
        for(int i=0; i < id.length; i++){
            tagMapper.deleteById(id[i]);
        }
    }

    @Override
    public void edit(String ids) {
        Tag tag = JSON.parseObject(ids,Tag.class);
        tagMapper.updateById(tag);
    }
}
