package com.cdtu.exam.service;

import com.baomidou.mybatisplus.core.injector.methods.SelectById;
import com.cdtu.exam.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cdtu.exam.vo.DataVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author SuRui
 * @since 2021-04-26
 */
public interface UserService extends IService<User> {

    /**
     * 查询失物管理信息接口
     * @return
     */
    public DataVO<User> findData(@Param("page") Integer page, @Param("limit") Integer limit, @Param("username") String username, @Param("type") String type);

    /**
     * 删除失物管理信息接口
     *
     * @param ids 批量删除删除的Id
     * @return
     */
    public void deleteByIds(String ids);


    //public void editUser(UserVO userVO);
    /**
     * 修改失物管理信息接口
     *
     * @param ids 要编辑的ids字符串
     * @return
     */
    public void edit(String ids);

    /**
     * 前端修改User信息接口
     *
     * @param ids 要编辑的ids字符串
     * @return
     */
    public void editVO(String ids);
    /**
     * 修改失物管理信息接口
     *
     * @param ids 新增用户
     * @return
     */
    public void save(String ids);

    /**
     * 验证登录信息
     * @param username :用户名
     * @param password ：密码
     * @return status
     */
    public Integer dengLu(@Param("username") String username, @Param("password") String password);

    public User findByUsername(@Param("username") String username);
}
