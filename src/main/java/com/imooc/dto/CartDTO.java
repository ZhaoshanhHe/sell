package com.imooc.dto;

import lombok.Data;

/**
 * Created with IDEA
 * User:赵无聊
 * Date:2018/5/7
 * Time:17:03
 */
@Data
public class CartDTO {
    private String productId;
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
