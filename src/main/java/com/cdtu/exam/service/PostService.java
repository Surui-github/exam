package com.cdtu.exam.service;

import com.cdtu.exam.entity.Post;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cdtu.exam.vo.DataVO;
import com.cdtu.exam.vo.PostVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author SuRui
 * @since 2021-04-26
 */
public interface PostService extends IService<Post> {

    /**
     * 查询失物管理信息接口
     * @param page :页码
     * @param limit ：每页row
     * @param flag ：失物/招领
     * @param typeId ：状态
     * @return
     */
    public DataVO<Post> findData(@Param("page") Integer page, @Param("limit") Integer limit, @Param("flag") String flag, @Param("typeId") String typeId);

    /**
     * 前台查询所有启示
     * @param page :页码
     * @param limit ：每页row
     * @param tagsId ：标签ID
     * @return
     */
    public DataVO<PostVO> findDataVO(@Param("page") Integer page, @Param("limit") Integer limit, @Param("tagsId") String tagsId, @Param("typeId") String typeId, @Param("columnValue") String columnValue);
    /**
     * 启示详情
     * @param id :postID
     * @return
     */
    public PostVO details(@Param("id") String id);

    /**
     * 根据用户名查询他发布的启事
     * @param username
     * @return
     */
    public List<PostVO> selectByUsername(@Param("username") String username);

    /**
     * 保存数据
     * @param ids json数据
     */
    public void save(@Param("ids") String ids, @Param("username") String username, @Param("createTime") String createTime);

    /**
     * 批量删除
     * @param ids 根据id删除
     */
    public void deleteByIds(String ids);

    /**
     * 修改类型管理信息接口
     *
     * @param ids 要编辑的ids字符串
     * @return
     */
    public void edit(String ids);

}
