package com.imooc.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.Utils.serializer.Date2LongSerializer;
import com.imooc.dataObject.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IDEA
 * User:赵无聊
 * Date:2018/5/7
 * Time:15:43
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    private  String orderId;
    private  String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal orderAmount;
    private Integer orderStatus;
    private Integer payStatus;
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;
    List<OrderDetail> orderDetailList = new ArrayList<>();
}
