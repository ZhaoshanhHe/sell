package com.imooc.enums;

import lombok.Getter;

/**
 * 商品状态
 * Created with IDEA
 * User:赵无聊
 * Date:2018/5/1
 * Time:22:23
 */
@Getter
public enum ProductStatus {

    UP(0, "上架"), DOWN(1, "下架");
    private Integer code;
    private String message;

    ProductStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
