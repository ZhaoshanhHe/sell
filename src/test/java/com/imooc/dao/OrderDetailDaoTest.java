package com.imooc.dao;

import com.imooc.dataObject.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IDEA
 * User:赵无聊
 * Date:2018/5/3
 * Time:22:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDaoTest {
    @Autowired
    private OrderDetailDao orderDetailDao;

    @Test
    public void saveTest(){
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setDetailId("666");
        orderDetail.setOrderId("111");
        orderDetail.setProductIcon("http:123.jpg");
        orderDetail.setProductId("123");
        orderDetail.setProductName("卤肉饭");
        orderDetail.setProductPrice(new BigDecimal(1.2));
        orderDetail.setProductQuantity(2);
        orderDetailDao.save(orderDetail);
    }

    @Test
    public void findByOrderId() {
        System.out.println(orderDetailDao.findByOrderId("111"));
    }
}