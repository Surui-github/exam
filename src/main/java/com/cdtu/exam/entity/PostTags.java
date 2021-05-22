package com.cdtu.exam.entity;

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
public class PostTags implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    private String postsId;

    private String tagsId;


}
