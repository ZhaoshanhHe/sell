package com.imooc.exception;

import com.imooc.enums.ResultEnum;

/**
 * Created with IDEA
 * User:赵无聊
 * Date:2018/5/7
 * Time:15:58
 */
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }
}
