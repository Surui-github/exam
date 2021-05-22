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
 * @since 2021-04-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Comment implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    private String avatar;

    private String content;

    private LocalDateTime createTime;

    private String email;

    private String nickname;

    private String postId;

    private String parentCommentId;


}
