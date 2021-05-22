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
 * @since 2021-04-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Notice implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * ID
     */
    private String id;

    /**
     * 创建人
     */
    private String username;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建时间
     */
    private LocalDateTime creatTime;

    /**
     * 通知标题
     */
    private String title;


}
