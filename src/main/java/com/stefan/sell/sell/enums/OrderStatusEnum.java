package com.stefan.sell.sell.enums;

import lombok.Getter;

/**
 * Created by Stefan
 * Create Date 2017-12-03/16:46
 */
@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消"),
    ;
    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
