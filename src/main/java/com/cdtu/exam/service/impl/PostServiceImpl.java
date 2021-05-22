package com.cdtu.exam.service.impl;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.LocalDateTimeUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cdtu.exam.entity.*;
import com.cdtu.exam.mapper.PostMapper;
import com.cdtu.exam.mapper.PostTagsMapper;
import com.cdtu.exam.mapper.TypeMapper;
import com.cdtu.exam.mapper.UserMapper;
import com.cdtu.exam.service.PostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cdtu.exam.vo.DataVO;
import com.cdtu.exam.vo.PostVO;
import javafx.geometry.Pos;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author SuRui
 * @since 2021-04-26
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {

    @Autowired
    private PostMapper postMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TypeMapper typeMapper;


    @Autowired
    private PostTagsMapper postTagsMapper;

    @Override
    public DataVO<Post> findData(@Param("page") Integer page, @Param("limit") Integer limit, @Param("flag") String flag, @Param("typeId") String typeId) {
        DataVO dataVO = new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");
        dataVO.setCount(postMapper.selectCount(null));

        QueryWrapper<Post> wrapper = new QueryWrapper<>();
        Map<String,Object> map = new HashMap<>(10);
        map.put("flag" , flag);
        map.put("type_id" , typeId);
        wrapper.allEq(map,false);
        if(flag == null && typeId == null){
            Page<Post> page1 = new Page<>(page,limit);
            postMapper.selectPage(page1,null);
            dataVO.setData(page1.getRecords());
            return dataVO;
        }
        Page<Post> page1 = new Page<>(page,limit);
        postMapper.selectPage(page1,wrapper);
        dataVO.setData(page1.getRecords());
        return dataVO;
    }

    @Override
    public DataVO<PostVO> findDataVO(@Param("page") Integer page, @Param("limit") Integer limit, @Param("tagsId") String tagsId, @Param("typeId") String typeId, @Param("columnValue") String columnValue) {
        DataVO dataVO = new DataVO();
        dataVO.setCode(0);
        dataVO.setMsg("");
        dataVO.setCount(postMapper.selectCount(null));
        if(columnValue != ""){
            Page<Post> page1 = new Page<>(page,limit);
            QueryWrapper<Post> wrapper = new QueryWrapper<>();
            wrapper.like("title", columnValue);
            postMapper.selectPage(page1,wrapper);
            List<Post> postList = page1.getRecords();
            List<PostVO> postVOList = new ArrayList<>();
            for (Post post : postList) {
                PostVO postVO = new PostVO();
                BeanUtils.copyProperties(post,postVO);
                QueryWrapper wrapper1 = new QueryWrapper();
                wrapper1.eq("id",post.getUserId());
                QueryWrapper wrapper2 = new QueryWrapper();
                wrapper2.eq("id",post.getTypeId());
                postVO.setUsername(userMapper.selectOne(wrapper1).getUsername());
                postVO.setAvatar(userMapper.selectOne(wrapper1).getAvatar());
                postVO.setType(userMapper.selectOne(wrapper1).getType());
                postVO.setTypeName(typeMapper.selectOne(wrapper2).getName());
                postVOList.add(postVO);
            }

            dataVO.setData(postVOList);
            return dataVO;
        }
        if(tagsId == "" && typeId == ""){
            Page<Post> page1 = new Page<>(page,limit);
            postMapper.selectPage(page1,null);
            List<Post> postList = page1.getRecords();
            List<PostVO> postVOList = new ArrayList<>();
            for (Post post : postList) {
                PostVO postVO = new PostVO();
                BeanUtils.copyProperties(post,postVO);
                QueryWrapper wrapper = new QueryWrapper();
                wrapper.eq("id",post.getUserId());
                QueryWrapper wrapper1 = new QueryWrapper();
                wrapper1.eq("id",post.getTypeId());
                postVO.setUsername(userMapper.selectOne(wrapper).getUsername());
                postVO.setAvatar(userMapper.selectOne(wrapper).getAvatar());
                postVO.setType(userMapper.selectOne(wrapper).getType());
                postVO.setTypeName(typeMapper.selectOne(wrapper1).getName());
                postVOList.add(postVO);
            }
            dataVO.setData(postVOList);
            return dataVO;
        }
        if(typeId != null && typeId != ""){
            Page<Post> page1 = new Page<>(page,limit);
            QueryWrapper<Post> wrapper = new QueryWrapper<>();
            wrapper.eq("type_id", typeId);
            postMapper.selectPage(page1,wrapper);
            List<Post> postList = page1.getRecords();
            List<PostVO> postVOList = new ArrayList<>();
            for (Post post : postList) {
                PostVO postVO = new PostVO();
                BeanUtils.copyProperties(post,postVO);
                QueryWrapper wrapper1 = new QueryWrapper();
                wrapper1.eq("id",post.getUserId());
                postVO.setUsername(userMapper.selectOne(wrapper1).getUsername());
                postVO.setAvatar(userMapper.selectOne(wrapper1).getAvatar());
                postVO.setType(userMapper.selectOne(wrapper1).getType());
                postVO.setTypeName(typeMapper.selectById(typeId).getName());
                postVOList.add(postVO);
            }
            dataVO.setData(postVOList);
            return dataVO;
        }
        if(tagsId != null && tagsId != ""){
            Page<Post> page1 = new Page<>(page,limit);
            QueryWrapper<PostTags> wrapper = new QueryWrapper<>();
            wrapper.eq("tags_id", tagsId);
            List<PostTags> postTags = postTagsMapper.selectList(wrapper);
            List<Post> postList = new ArrayList<>();
            for (PostTags postTag : postTags) {
                Post post = postMapper.selectById(postTag.getPostsId());
                postList.add(post);
            }
            List<PostVO> postVOList = new ArrayList<>();
            for (Post post : postList) {
                PostVO postVO = new PostVO();
                BeanUtils.copyProperties(post,postVO);
                QueryWrapper wrapper1 = new QueryWrapper();
                wrapper1.eq("id",post.getUserId());
                QueryWrapper wrapper2 = new QueryWrapper();
                wrapper2.eq("id",post.getTypeId());
                postVO.setUsername(userMapper.selectOne(wrapper1).getUsername());
                postVO.setAvatar(userMapper.selectOne(wrapper1).getAvatar());
                postVO.setType(userMapper.selectOne(wrapper1).getType());
                postVO.setTypeName(typeMapper.selectOne(wrapper2).getName());
                postVOList.add(postVO);
            }
            dataVO.setData(postVOList);
            return dataVO;
        }
        return null;
    }



    @Override
    public PostVO details(String id) {
        Post post = postMapper.selectById(id);

        PostVO postVO = new PostVO();
        BeanUtils.copyProperties(post,postVO);

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("id",post.getUserId());
        QueryWrapper wrapper1 = new QueryWrapper();
        wrapper1.eq("id",post.getTypeId());

        postVO.setUsername(userMapper.selectOne(wrapper).getUsername());
        postVO.setAvatar(userMapper.selectOne(wrapper).getAvatar());
        postVO.setEmail(userMapper.selectOne(wrapper).getEmail());
        postVO.setTypeName(typeMapper.selectOne(wrapper1).getName());
        return postVO;
    }

    @Override
    public List<PostVO> selectByUsername(String username) {
        QueryWrapper wrapper3 = new QueryWrapper<>();
        wrapper3.eq("username", username);
        String id = userMapper.selectOne(wrapper3).getId();
        System.out.println("id:"+id);
        QueryWrapper wrapper2 = new QueryWrapper<>();
        wrapper2.eq("user_id", id);
        List<Post> postList = postMapper.selectList(wrapper2);
        postList.forEach(System.out::println);
        List<PostVO> postVOList = new ArrayList<>();
        for (Post post : postList) {
            PostVO postVO = new PostVO();
            BeanUtils.copyProperties(post,postVO);

            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("id",post.getUserId());
            QueryWrapper wrapper1 = new QueryWrapper();
            wrapper1.eq("id",post.getTypeId());

            postVO.setUsername(userMapper.selectOne(wrapper).getUsername());
            postVO.setAvatar(userMapper.selectOne(wrapper).getAvatar());
            postVO.setTypeName(typeMapper.selectOne(wrapper1).getName());
            postVOList.add(postVO);
        }

        return postVOList;
    }

    @Override
    public void save(@Param("ids") String ids, @Param("username") String username, @Param("createTime") String createTime) {
        Post post = JSON.parseObject(ids,Post.class);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        Date date = DateUtil.parse(createTime);
        LocalDateTime of = LocalDateTimeUtil.of(date);
        post.setCreateTime(of);
        post.setUserId(userMapper.selectOne(wrapper).getId());
        postMapper.insert(post);
    }

    @Override
    public void deleteByIds(String ids) {
        String[] id = ids.split(",");
        for(int i=0; i < id.length; i++){
            postMapper.deleteById(id[i]);
        }
    }

    @Override
    public void edit(String ids) {
        Post post = JSON.parseObject(ids,Post.class);
        postMapper.updateById(post);
    }
}
