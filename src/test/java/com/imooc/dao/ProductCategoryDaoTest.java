package com.imooc.dao;

import com.imooc.dataObject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by 赵山河
 * 2018/3/8 23:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {
    @Autowired
    private ProductCategoryDao productCategoryDao;
    @Test
    public void findOneTest(){
        ProductCategory productCategory=productCategoryDao.findOne(1);
        System.out.println(productCategory.toString());
    }


}