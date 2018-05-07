package com.imooc.dto;


import com.imooc.dataObject.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created with IDEA
 * User:赵无聊
 * Date:2018/5/7
 * Time:15:43
 */
@Data
public class OrderDTO {
    private  String orderId;
    private  String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal orderAmount;
    private Integer orderStatus;
    private Integer payStatus;
    private Date createTime;
    private Date updateTime;
    List<OrderDetail> orderDetailList;
}
