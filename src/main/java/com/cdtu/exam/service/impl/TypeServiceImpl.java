package com.cdtu.exam.service.impl;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdtu.exam.entity.Post;
import com.cdtu.exam.entity.Type;
import com.cdtu.exam.entity.User;
import com.cdtu.exam.mapper.TypeMapper;
import com.cdtu.exam.service.TypeService;
import com.cdtu.exam.vo.DataVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author SuRui
 * @since 2021-03-22
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {

    @Autowired
    private TypeMapper typeMapper;
    /**
     * 实现查询标签
     * @return
     */
    @Override
    public DataVO<Type> findDate(@Param("page") Integer page, @Param("limit") Integer limit, @Param("name") String name, @Param("typeWeb") String typeWeb) {
        DataVO dataVO = new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");
        dataVO.setCount(typeMapper.selectCount(null));

        if(typeWeb != null && typeWeb != ""){
            dataVO.setData(typeMapper.selectList(null));
            return dataVO;
        }
        QueryWrapper<Type> wrapper = new QueryWrapper<>();
        wrapper.like("name",name);
        if(name == null){
            Page<Type> page1 = new Page<>(page,limit);
            typeMapper.selectPage(page1,null);
            dataVO.setData(page1.getRecords());
            return dataVO;
        }
        Page<Type> page1 = new Page<>(page,limit);
        typeMapper.selectPage(page1,wrapper);
        dataVO.setData(page1.getRecords());

        return dataVO;
    }

    @Override
    public void save(String ids) {
        Type type = JSON.parseObject(ids,Type.class);
        typeMapper.insert(type);
    }

    @Override
    public void deleteByIds(String ids) {
        String[] id = ids.split(",");
        for(int i=0; i < id.length; i++){
            typeMapper.deleteById(id[i]);
        }
    }

    @Override
    public void edit(String ids) {
        Type type = JSON.parseObject(ids,Type.class);
        typeMapper.updateById(type);
    }
}
