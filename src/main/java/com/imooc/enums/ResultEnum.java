package com.imooc.enums;

import lombok.Getter;

/**
 * Created with IDEA
 * User:赵无聊
 * Date:2018/5/7
 * Time:15:59
 */
@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"商品库存不足")
    ;
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
