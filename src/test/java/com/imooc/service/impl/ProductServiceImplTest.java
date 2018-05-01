package com.imooc.service.impl;

import com.imooc.dataObject.ProductInfo;
import com.imooc.enums.ProductStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IDEA
 * User:赵无聊
 * Date:2018/5/1
 * Time:22:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {
   @Autowired
   private ProductServiceImpl productService;

    @Test
    public void findOne() {
        ProductInfo productInfo = productService.findOne("123456");
        Assert.assertEquals("123456",productInfo.getProductId());
    }

    @Test
    public void findUpAll() {

        List<ProductInfo> upAll = productService.findUpAll();
        Assert.assertNotEquals(0,upAll.size());
    }

    @Test
    public void findAll() {
        PageRequest request=new PageRequest(0,2);
        Page<ProductInfo> all = productService.findAll(request);
        System.out.println(all.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("神舟");
        BigDecimal bigDecimal=new BigDecimal(2300);
        productInfo.setProductPrice(bigDecimal);
        productInfo.setProductStock(100);
        productInfo.setProductDescription("打游戏");
        productInfo.setProductIcon("https://123.jpg");
        productInfo.setProductStatus(ProductStatus.DOWN.getCode());
        productInfo.setCategoryType(3);
        ProductInfo productInfo1 = productService.save(productInfo);
        Assert.assertNotNull(productInfo1);
    }
}