package com.cdtu.exam.vo;


import lombok.Data;

import java.util.List;

/**
 * @author : SuRui
 * @ClassName : DataVO
 * @Description : TODO
 * @date : 2021/3/21 17:23
 **/
@Data
public class DataVO<T> {
    private Integer code;
    private String msg;
    private Integer count;
    private List<T> data;
}
