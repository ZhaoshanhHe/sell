package com.imooc.dao;

import com.imooc.dataObject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.management.OperatingSystemMXBean;
import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created with IDEA
 * User:赵无聊
 * Date:2018/5/3
 * Time:21:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {
    @Autowired
    private OrderMasterDao orderMasterDao;

    private final String OPENID="123";

    @Test
    public void saveTest(){
        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("GUCCI");
        orderMaster.setBuyerPhone("18888888888");
        orderMaster.setBuyerAddress("回龙观");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        OrderMaster master = orderMasterDao.save(orderMaster);
        Assert.assertNotNull(master);
    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest pageRequest=new PageRequest(0,1);
        Page<OrderMaster> orderMasterPage = orderMasterDao.findByBuyerOpenid(OPENID, pageRequest);
        Assert.assertNotNull(orderMasterPage.getTotalElements());
    }
}