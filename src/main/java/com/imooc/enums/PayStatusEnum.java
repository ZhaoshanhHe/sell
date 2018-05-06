package com.imooc.enums;

import lombok.Getter;

/**
 * Created with IDEA
 * User:赵无聊
 * Date:2018/5/3
 * Time:21:28
 */
@Getter
public enum PayStatusEnum {
    WAIT(0,"未支付"),
    SUCCESS(1,"支付成功"),
    ;
    private Integer code;
    private String message;
    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
