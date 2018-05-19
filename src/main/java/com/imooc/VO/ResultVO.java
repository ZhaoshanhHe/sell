package com.imooc.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;



/**
 * http请求返回的对象
 * Created with IDEA
 * User:赵无聊
 * Date:2018/5/2
 * Time:21:38
 */
@Data
public class ResultVO<T> {
    /**
     * 错误码
     */
    private Integer code;
    /*提示信息*/
    private String msg = "";
    /*具体内容*/
    private T data;
}
