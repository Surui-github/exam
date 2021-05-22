package com.cdtu.exam.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author SuRui
 * @since 2021-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Feedback implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * ID
     */
    private String id;

    /**
     * 反馈者
     */
    private String username;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 反馈时间
     */
    private LocalDateTime ctime;


}
