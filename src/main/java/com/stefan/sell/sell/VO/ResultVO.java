package com.stefan.sell.sell.VO;

import lombok.Data;

/**
 * Created by Stefan
 * Create Date 2017-12-02/19:51
 */

@Data
public class ResultVO<T> {
    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private T data;
}
