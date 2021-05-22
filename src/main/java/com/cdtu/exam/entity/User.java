package com.cdtu.exam.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

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
@Component
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    private String avatar;

    private LocalDateTime createTime;

    private String email;

    private String nickname;

    private String password;

    private Integer type;

    private LocalDateTime updateTime;

    private String username;



}
