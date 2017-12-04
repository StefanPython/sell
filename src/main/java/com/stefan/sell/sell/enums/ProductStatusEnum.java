package com.stefan.sell.sell.enums;

import lombok.Getter;

/**
 * Created by Stefan
 * Create Date 2017-12-02/18:27
 */
@Getter
public enum ProductStatusEnum {
    UP(0, "在架"),
    DOWN(1, "下架")
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
