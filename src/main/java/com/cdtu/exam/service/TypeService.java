package com.cdtu.exam.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.cdtu.exam.entity.Type;
import com.cdtu.exam.vo.DataVO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author SuRui
 * @since 2021-04-26
 */
public interface TypeService extends IService<Type> {

    /**
     * 查询标签
     * @return
     */
    public DataVO<Type> findDate(@Param("page") Integer page, @Param("limit") Integer limit,@Param("name") String name,  @Param("typeWeb") String typeWeb);

    /**
     * 保存数据
     * @param ids json数据
     */
    public void save(String ids);

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
