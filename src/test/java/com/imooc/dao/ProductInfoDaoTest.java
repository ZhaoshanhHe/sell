package com.imooc.dao;

import com.imooc.dataObject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;


/**
 * Created with IDEA
 * User:赵无聊
 * Date:2018/5/1
 * Time:19:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDaoTest {
    @Autowired
    private ProductInfoDao productInfoDao;
    @Test
    public void saveTest(){
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("MacBookPro");
        BigDecimal bigDecimal=new BigDecimal(12300);
        productInfo.setProductPrice(bigDecimal);
        productInfo.setProductStock(100);
        productInfo.setProductDescription("我想要");
        productInfo.setProductIcon("https://123.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(3);
        ProductInfo result=productInfoDao.save(productInfo);
        Assert.assertNotNull(result);
    }
    @Test
   public  void findByProductStatus() {
        List<ProductInfo> list = productInfoDao.findByProductStatus(0);
        Assert.assertNotEquals(0,list.size());

    }
}