package com.cdtu.exam.vo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author : SuRui
 * @ClassName : PostVO
 * @Description : TODO
 * @date : 2021/4/30 17:02
 **/
@Data
public class PostVO {
    private static final long serialVersionUID=1L;

    /**
     * ID
     */
    private String id;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 首图
     */
    private String firstPicture;

    /**
     * 标记：用来标识失物，拾物
     */
    private String flag;

    /**
     * 赞赏开关：开或者关
     */
    private Boolean isAppreciation;

    /**
     * 评论开关
     */
    private Boolean isComment;

    /**
     * 是否推荐
     */
    private Boolean isPublish;

    /**
     * 是否推荐
     */
    private Boolean isRecommend;

    /**
     * 转载申明是否开启
     */
    private Boolean isShareStatement;

    /**
     * 标题
     */
    private String title;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 浏览次数
     */
    private Integer views;

    /**
     * 描述
     */
    private String description;

    private String username;

    private String typeName;

    private String avatar;

    private String email;


    private Integer type;

}
