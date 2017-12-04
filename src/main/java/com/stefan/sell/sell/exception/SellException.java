package com.stefan.sell.sell.exception;

import com.stefan.sell.sell.enums.ResultEnum;

/**
 * Created by Stefan
 * Create Date 2017-12-03/19:10
 */
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
