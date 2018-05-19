package com.imooc.service;

import com.imooc.dto.OrderDTO;

/**
 * Created with IDEA
 * User:赵无聊
 * Date:2018/5/19
 * Time:18:01
 */
public interface BuyerService {
    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);
}
