package com.imooc.enums;

import lombok.Getter;

/**
 * Created with IDEA
 * User:赵无聊
 * Date:2018/5/3
 * Time:21:22
 */
@Getter
public enum OrderStatusEnum {
    NEW(0,"新订单"),
    FINISH(1,"完结订单"),
    CANCEL(2,"取消订单"),
    ;
    private Integer code;
    private String message;
    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
