package com.imooc.service.impl;

import com.imooc.dataObject.OrderDetail;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.OrderStatusEnum;
import com.imooc.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IDEA
 * User:赵无聊
 * Date:2018/5/7
 * Time:22:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {
    @Autowired
    private OrderServiceImpl orderServiceImpl;
    private final String BUYER_OPENID="110";
    private final String ORDER_ID="1525704476984728083";
    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerAddress("回龙观");
        orderDTO.setBuyerName("赵山河");
        orderDTO.setBuyerPhone("123456");
        orderDTO.setBuyerOpenid(BUYER_OPENID);
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("123456");
        orderDetail.setProductQuantity(2);
        orderDetailList.add(orderDetail);
        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderServiceImpl.create(orderDTO);
        log.info("[创建订单] result={}",result);
    }

    @Test
    public void findOne() {
        OrderDTO orderDTO = orderServiceImpl.findOne(ORDER_ID);
        log.info("查询单个订单 orderDTO={}",orderDTO);
        Assert.assertEquals(ORDER_ID,orderDTO.getOrderId());
    }

    @Test
    public void findList() {
        PageRequest pageRequest = new PageRequest(0,2);
        Page<OrderDTO> orderDTOS = orderServiceImpl.findList(BUYER_OPENID, pageRequest);
        Assert.assertNotEquals(0,orderDTOS.getTotalElements());
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderServiceImpl.findOne(ORDER_ID);
        OrderDTO dto = orderServiceImpl.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),dto.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderServiceImpl.findOne(ORDER_ID);
        OrderDTO dto = orderServiceImpl.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISH.getCode(),dto.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderServiceImpl.findOne(ORDER_ID);
        OrderDTO dto = orderServiceImpl.finish(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),dto.getOrderStatus());
    }
}